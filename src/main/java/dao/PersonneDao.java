package dao;

import entities.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonneDao {

    //Entity Manager Factory
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    //Insertion
    public static void insert(Personne personne){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(personne);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    //Supression
    public static void delete(int primaryKey){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            //Commencer la transaction
            transaction.begin();
            //Trouver la personne dans la base de donnée en fournissant la class et la clé primaire de l'objet
            Personne personne = entityManager.find(Personne.class, primaryKey);
            //Suppression de la personne dans la basse de donnée à l'aide de "remove"
            entityManager.remove(personne);
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    //Updating - modification
    public static void update(int primaryKey, String name){
        //Creation de l'objet transaction
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            //Commencer la transaction
            transaction.begin();
            //Trouver la personne dans la base de donnée ne fournissant la class et la clé primaire de l'objet
            Personne personne = entityManager.find(Personne.class, primaryKey);
            //Changement de l'attribut
            personne.setNom(name);
            //Update dans la base de donné
            entityManager.merge(personne);
            //commit à la base de donnée
            transaction.commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }





    }


}
