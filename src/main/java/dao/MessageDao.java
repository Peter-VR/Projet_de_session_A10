package dao;

import entities.Message;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
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

    public static void delete(Integer id) {
        if (id == null)
            return;
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

    public static List<Message> findAll() {
        return find("from Message");
    }

    public static List<Message> findOne(Integer id) {
        return find("from Message m where m.idmessage=?1", id);
    }

    public static List<Message> findFrom(Integer idPersonne) {
        return find("from Message m where m.idpersonneenvoyer=?1 order by datemessage desc", idPersonne);
    }

    public static List<Message> findTo(Integer idPersonne) {
        return find("from Message m where m.idpersonnerecevoir=?1 order by datemessage desc", idPersonne);
    }

    public static List<Message> find(Integer fromId, Integer toId, String subject, String content) {
        var hql = "from Message m where 1=1";
        var params = new ArrayList<Object>();

        var c = 1;
        if (fromId != null) {
            hql += " and m.idpersonneenvoyer=?" + c++;
            params.add(fromId);
        }
        if (toId != null) {
            hql += " and m.idpersonnerecevoir=?" + c++;
            params.add(toId);
        }
        if (subject != null && !subject.isEmpty()) {
            hql += " and m.objet like ?" + c++;
            params.add("%" + subject + "%");
        }
        if (content != null && !content.isEmpty()) {
            hql += " and m.contenu like ?" + c++;
            params.add("%" + content + "%");
        }
        return find(hql + " order by datemessage desc", params.toArray());
    }
}
