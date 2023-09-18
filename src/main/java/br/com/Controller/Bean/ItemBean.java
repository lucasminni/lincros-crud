package br.com.Controller.Bean;

import br.com.Model.DAO.GenericDAO;
import br.com.Model.Entity.Item;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "itemBean")
public class ItemBean {

    private final Item item = new Item();
    private final GenericDAO<Item> genericDAO = new GenericDAO<>();

    public Item getItem() {
        return item;
    }

    public List<Item> getItens() {
        List<Item> itens = genericDAO.findAll(Item.class);
        return itens;
    }

    public String adicionarItem() {
        genericDAO.add(item);
        return "/cadastroItem.jsf";
    }
}
