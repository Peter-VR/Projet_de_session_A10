package dao;

import entities.Offretravail;
import entities.Personne;

import javax.persistence.*;
import java.util.List;

public class OffreTravailDAO {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    //Insertion
    public static void insert(Offretravail offretravail){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(offretravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void delete(int idOffreTravail){

        EntityTransaction transaction = entityManager.getTransaction();
        Offretravail offretravail = entityManager.find(Offretravail.class, idOffreTravail);
        try {
            transaction.begin();
            entityManager.remove(offretravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void updateDescription(int idOffreTravail, String description){

        EntityTransaction transaction = entityManager.getTransaction();
        Offretravail offretravail = entityManager.find(Offretravail.class, idOffreTravail);

        try {
            transaction.begin();
            //update the field
            offretravail.setDescription(description);

            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static List<Offretravail> getOffresTravails(){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            Query query = entityManager.createQuery("select a from Offretravail a", Offretravail.class);
            return query.getResultList();


        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    public static int nextID() {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            Query query = entityManager.createQuery("select a from Offretravail a", Offretravail.class);
            return query.getResultList().size()+1;


        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
