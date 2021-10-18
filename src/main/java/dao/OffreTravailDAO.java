/*
* Created by: Mario Blanco
* Project: A10
* */

package dao;

import entities.Offretravail;
import javax.persistence.*;
import java.util.List;

public class OffreTravailDAO {

    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");

    //Insertion
    public static void insert(Offretravail offretravail) {
        //Creation de l'objet transaction
        EntityManager entitymanager = emfactory.createEntityManager();

        EntityTransaction transaction = entitymanager.getTransaction();

        try {
            transaction.begin();
            entitymanager.persist(offretravail);
            transaction.commit();
        } finally {
            entitymanager.close();
        }
    }

    public static void delete(int idOffreTravail) {

        EntityManager entityManager = emfactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        Offretravail offretravail = entityManager.find(Offretravail.class, idOffreTravail);

        try {
            transaction.begin();
            entityManager.remove(offretravail);
            transaction.commit();
        } finally {
            entityManager.close();
        }
    }

    public static void update(Offretravail offremodified) {

        EntityManager entityManager = emfactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(offremodified);
            transaction.commit();
        } finally {
            entityManager.close();
        }
    }

    public static void updateDescription(int idOffreTravail, String description) {

        EntityManager entityManager = emfactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Offretravail offretravail = entityManager.find(Offretravail.class, idOffreTravail);

        try {
            transaction.begin();
            //update the field
            offretravail.setDescription(description);

            transaction.commit();
        } finally {
            entityManager.close();
        }
    }

    public static List<Offretravail> getOffresTravails() {
        EntityManager entityManager = emfactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            return entityManager.createQuery("select a from Offretravail a", Offretravail.class)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static int nextID() {
        EntityManager entityManager = emfactory.createEntityManager();

        try {

            Query query = entityManager.createQuery("SELECT max(o.idoffretravail) FROM Offretravail o");
            int maxID = (int)query.getSingleResult();

            System.out.println(maxID);
            return maxID+1;

        } finally {
            entityManager.close();
        }
    }


    public static Offretravail getOffre(int id){

        EntityManager entityManager = emfactory.createEntityManager();

        try {
            Offretravail offretravail = entityManager.find(Offretravail.class, id);

        return offretravail;
        } finally {
            entityManager.close();
        }

    }


}
