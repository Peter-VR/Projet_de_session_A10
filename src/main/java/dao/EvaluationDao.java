package dao;

import entities.Evaluation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EvaluationDao {
    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("default");

    public static void insert(Evaluation entity) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static void update(Evaluation entity, String commentaire) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            entity.setCommentaire(commentaire);
            manager.merge(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static void delete(Evaluation entity) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }


    public static List<Evaluation> getAll() {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            var list = manager.createQuery("from Message", Evaluation.class).getResultList();
            manager.getTransaction().commit();
            return list;
        } finally {
            manager.close();
        }
    }
}
