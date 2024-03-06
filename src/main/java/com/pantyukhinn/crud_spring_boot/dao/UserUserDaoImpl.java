package com.pantyukhinn.crud_spring_boot.dao;

import com.pantyukhinn.crud_spring_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserUserDaoImpl implements UserDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void create(User user) {
        manager.persist(user);
    }

    @Override
    public User read(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        manager.merge(user);
    }

    @Override
    public void delete(User user) {
        manager.remove(manager.find(User.class, user.getId()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getList() {
        return manager.createQuery("from User").getResultList();
    }
}
