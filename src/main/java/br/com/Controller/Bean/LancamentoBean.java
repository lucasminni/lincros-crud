package br.com.Controller.Bean;

import br.com.Model.DAO.GenericDAO;
import br.com.Model.Entity.Lancamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

    private final Lancamento lancamento = new Lancamento();
    private final GenericDAO<Lancamento> genericDAO = new GenericDAO<>();

    public void adicionarLancamento(Date dataInicial, Date dataFinal, Long valorTotal, String observacao) {
        genericDAO.adicionar(lancamento);
    }

}
