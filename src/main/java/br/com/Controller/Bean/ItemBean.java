package br.com.Controller.Bean;


import br.com.Model.DAO.GenericDAO;
import br.com.Model.Entity.Item;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "itemBean")
public class ItemBean<DaoGeneric> {

    private final Item item = new Item();
    private final GenericDAO<Item> genericDAO = new GenericDAO<>();

    public void adicionarItem(Item item) {
        genericDAO.adicionar(item);
    }

}
