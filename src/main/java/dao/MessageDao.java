package dao;

import entities.Message;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MessageDao {
    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("default");

    public static void insert(Message entity) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static void delete(int id) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            var entity = manager.find(Message.class, id);
            manager.remove(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static void update(int id, String contenu) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            var entity = manager.find(Message.class, id);
            entity.setContenu(contenu);
            manager.merge(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static List<Message> getAll() {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            var list = manager.createQuery("from Message", Message.class).getResultList();
            manager.getTransaction().commit();
            return list;
        } finally {
            manager.close();
        }
    }
}
