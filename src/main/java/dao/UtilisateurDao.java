package dao;

import entities.Personne;
import entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UtilisateurDao {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    //Insertion
    public static void insert(Utilisateur user){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void delete(int primaryKey){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            //Commencer la transaction
            transaction.begin();
            //Trouver l'utilisateur dans la base de donnée en fournissant la class et la clé primaire de l'objet
            Utilisateur utilisateur = entityManager.find(Utilisateur.class, primaryKey);
            //Suppression de l'utilisateur dans la basse de donnée à l'aire de "remove"
            entityManager.remove(utilisateur);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
