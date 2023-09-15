package br.com.Controller.Bean;

import br.com.Model.DAO.GenericDAO;
import br.com.Model.Entity.Lancamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

    private final Lancamento lancamento = new Lancamento();
    private final List<Lancamento> lancamentos = new ArrayList<Lancamento>();
    private final GenericDAO<Lancamento> genericDAO = new GenericDAO<>();

    public Lancamento getLancamento() {
        return lancamento;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void adicionarLancamento(Lancamento lancamento) {
        genericDAO.add(lancamento);
    }


}
