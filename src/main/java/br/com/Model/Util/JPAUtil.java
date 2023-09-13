package br.com.Model.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("lincros");
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


}
