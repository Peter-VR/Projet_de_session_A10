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

    public static void update(Message entity, String contenu) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            entity.setContenu(contenu);
            manager.merge(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static void delete(Message entity) {
        var manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

    public static List<Message> find(String hql, Object... params) {
        var manager = factory.createEntityManager();
        try {
            var query = manager.createQuery(hql, Message.class);
            for (var i = 0; i < params.length; i++)
                query.setParameter(i + 1, params[i]);
            manager.getTransaction().begin();
            var list = query.getResultList();
            manager.getTransaction().commit();
            return list;
        } finally {
            manager.close();
        }
    }

    public static List<Message> find() {
        return find("from Message");
    }

    public static List<Message> findFrom(Integer idPersonne) {
        return find("from Message m where m.idpersonneenvoyer=?1", idPersonne);
    }
}
