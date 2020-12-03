package com.max.spring.rest.dao;

import com.max.spring.rest.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            sessionFactory.getCurrentSession().save(user);
        } else updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findById(long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        if (session.contains(findById(id))) {
            User user = findById(id);
            session.remove(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u", User.class);
        return query.getResultList();
    }
}
