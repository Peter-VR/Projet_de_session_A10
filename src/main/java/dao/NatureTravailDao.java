package dao;

import entities.Message;
import entities.Naturetravail;
import entities.Offretravail;
import javax.persistence.*;
import java.util.List;


public class NatureTravailDao {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    //Insertion
    public static void insert(Naturetravail NatureTravail){

    //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(NatureTravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


    public static void delete(String nom){

        EntityTransaction transaction = entityManager.getTransaction();
        Naturetravail naturetravail = entityManager.find(Naturetravail.class, nom);
        try {
            transaction.begin();
            entityManager.remove(naturetravail);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void update(String nom) {
        var manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Naturetravail entity = manager.find(Naturetravail.class, nom);
            entity.setNom(nom);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static List<Naturetravail> getAll() {
        var manager = entityManagerFactory.createEntityManager();
        try {

            var list = manager.createQuery("select n from Naturetravail n", Naturetravail.class).getResultList();

            return list;

        }
        finally {
            manager.close();
        }
    }
}





