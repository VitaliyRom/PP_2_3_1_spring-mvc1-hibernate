package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private static final List<User> users = new ArrayList<>();

    static
     {
        users.add(new User("Victor", "Pavlov", "reading", 19));
        users.add(new User("Nina", "Suslova", "yoga",20));
        users.add(new User("Egor", "Druzhinin", "dancing", 45));
        users.add(new User("Mihail", "Boyarskiy", "football", 70));
        users.add(new User("Lada", "Dance", "fitness", 50));
    }
    @PersistenceContext
    private EntityManager enm;
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return enm.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        enm.persist(user);
        enm.flush();
    }

    @Override
    @Transactional
    public void delete(User user) {
        enm.remove(user);
        enm.flush();
    }

    @Override
    @Transactional
    public void edit( User user) {
        enm.merge(user);
        enm.flush();
    }


    @Override
    @Transactional
    public User getById(int id) {
        return  enm.find(User.class, id);
    }
}