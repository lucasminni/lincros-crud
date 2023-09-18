package br.com.Controller.Bean;

import br.com.Model.DAO.GenericDAO;
import br.com.Model.Entity.Item;
import br.com.Model.Entity.Lancamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

    private final Lancamento lancamento = new Lancamento();
    private final GenericDAO<Lancamento> genericDAO = new GenericDAO<>();
    private final List<Item> itensSelecionados = new ArrayList<>();

    private List<String> oidItensSelecionados;

    public Lancamento getLancamento() {
        return lancamento;
    }

    public List<String> getOidItensSelecionados() {
        return oidItensSelecionados;
    }

    public List<Item> getItensSelecionados() {
        return itensSelecionados;
    }

    public void setOidItensSelecionados(List<String> oidItensSelecionados) {
        this.oidItensSelecionados = oidItensSelecionados;
    }


    public String adicionarLancamento() {
        genericDAO.add(lancamento);
        return "/cadastroLancamento.jsf";
    }

    public List<Item> selecionarOidItens() {
        for (String oid : oidItensSelecionados) {
            itensSelecionados.add(genericDAO.findById(Long.parseLong(oid)));
        }
        return itensSelecionados;
    }

    public void somarValoresItens() {
        Long valorTotal = 0L;
        for (Item item : itensSelecionados) {
            valorTotal += item.getValor();
        }
        lancamento.setValorTotal(valorTotal);
    }

    public void removerItem(Item item) {
        itensSelecionados.remove(item);
        somarValoresItens();
        System.out.println("Depois de remover - " + lancamento.getValorTotal());
    }

    public void selecionarOidsESomarValoresItens() {
        selecionarOidItens();
        somarValoresItens();
        System.out.println("Antes de remover - " + lancamento.getValorTotal());
    }

}
