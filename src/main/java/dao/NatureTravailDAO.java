package dao;

import entities.Naturetravail;
import entities.Offretravail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class NatureTravailDAO {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    //Insertion
    public static void insert(Naturetravail naturetravail){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(naturetravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
