package dao;

import entities.Personne;

import javax.persistence.*;

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


    public static int findOne(int id, String password) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery( "Select e " + "from Personne e " + "where e.idpersonne = :id and e.motpasse=:password ",Personne.class );

        query.setParameter("id", id);
        query.setParameter("password", password);

        Personne person = (Personne) query.getSingleResult();

        if (person == null) return -1;
        else return person.getIdpersonne();

    }

    public static int nextID() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            Query query = entityManager.createQuery("SELECT max(p.idpersonne) FROM Personne p");
            int maxID = (int)query.getSingleResult();

            System.out.println(maxID);
            return maxID+1;

        } finally {
            entityManager.close();
        }
    }
}
