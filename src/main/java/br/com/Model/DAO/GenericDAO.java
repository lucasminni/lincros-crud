package br.com.Model.DAO;

import br.com.Model.Entity.Item;
import br.com.Model.Util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GenericDAO<E> {

    public E add(E entity) {
        EntityManager entityManager = JPAUtil.getEnityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        E e = entityManager.merge(entity);

        entityTransaction.commit();
        entityManager.close();

        return e;
    }

    public List<E> findAll(Class<E> entity) {
        EntityManager entityManager = JPAUtil.getEnityManager();

        List<E> lista = entityManager.createQuery("from " + entity.getName()).getResultList();
        return lista;
    }

    public Item findById(Long oid) {
        EntityManager entityManager = JPAUtil.getEnityManager();

        return entityManager.find(Item.class, oid);
    }
}
