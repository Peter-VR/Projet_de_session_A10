package dao;

import entities.Soumission;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SoumissionDAO {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    //Insertion
    public static void insert(Soumission soumission){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(soumission);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
