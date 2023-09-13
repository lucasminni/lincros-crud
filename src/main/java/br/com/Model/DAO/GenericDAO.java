package br.com.Model.DAO;

import br.com.Model.Util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<E> {

    public void adicionar(E entity) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        E e = entityManager.merge(entity);

        entityTransaction.commit();
        entityManager.close();
    }

}
