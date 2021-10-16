package dao;

import entities.Message;
import entities.Offretravail;

import javax.persistence.*;
import java.util.List;

public class OffreTravailDAO {


    //Insertion
    public static void insert(Offretravail offretravail) {
        //Creation de l'objet transaction
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");
        EntityManager entitymanager = emfactory.createEntityManager();

        EntityTransaction transaction = entitymanager.getTransaction();

        try {
            transaction.begin();
            entitymanager.persist(offretravail);
            transaction.commit();
        } finally {
            entitymanager.close();
            emfactory.close();
        }
    }

    public static void delete(int idOffreTravail) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emfactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        Offretravail offretravail = entityManager.find(Offretravail.class, idOffreTravail);

        try {
            transaction.begin();
            entityManager.remove(offretravail);
            transaction.commit();
        } finally {
            entityManager.close();
            emfactory.close();
        }
    }

    public static void update(Offretravail offremodified) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(offremodified);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void updateDescription(int idOffreTravail, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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

    public static List<Offretravail> getOffresTravails() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            return entityManager.createQuery("select a from Offretravail a", Offretravail.class)
                    .getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static int nextID() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            //TODO
            /*
            * select max id
            * */
            Query query = entityManager.createQuery("select a from Offretravail a", Offretravail.class);
            return query.getResultList().size() + 1;


        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static Offretravail getOffre(int id){

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emfactory.createEntityManager();

        Offretravail offretravail = entityManager.find(Offretravail.class, id);

        return offretravail;


    }
}
