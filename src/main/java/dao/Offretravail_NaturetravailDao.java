package dao;

import entities.Offretravail;
import entities.OffretravailNaturetravail;

import javax.persistence.*;
import java.util.List;

public class Offretravail_NaturetravailDao {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    //Insertion
    public static void insert(OffretravailNaturetravail Offretravail_Naturetravail){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(Offretravail_Naturetravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void delete(int idOffretravail_Naturetravail, int idnaturetravail){

        EntityTransaction transaction = entityManager.getTransaction();
        OffretravailNaturetravail offretravail = entityManager.find(OffretravailNaturetravail.class, idOffretravail_Naturetravail);
        try {
            transaction.begin();
            entityManager.remove(offretravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }



    public static List<OffretravailNaturetravail> getNatureOffresTravails(){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            Query query = entityManager.createQuery("select a from OffretravailNaturetravail a", OffretravailNaturetravail.class);
            return query.getResultList();


        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }


}

