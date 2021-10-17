package dao;

import entities.Soumission;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class SoumissionDAO {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    //Insertion
    public static void insert(Soumission soumission) {
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

    public static void delete(int idSoumission) {

        EntityTransaction transaction = entityManager.getTransaction();
        Soumission soumission = entityManager.find(Soumission.class, idSoumission);
        try {
            transaction.begin();
            entityManager.remove(soumission);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void updateDescription(int idSoumission, String description) {

        EntityTransaction transaction = entityManager.getTransaction();
        Soumission soumission = entityManager.find(Soumission.class, idSoumission);

        try {
            transaction.begin();
            //update the field
            soumission.setDescription(description);

            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static List<Soumission> getOffresTravails() {
        return entityManager.createQuery("select a from Soumission a", Soumission.class)
                .getResultList();
    }
}
