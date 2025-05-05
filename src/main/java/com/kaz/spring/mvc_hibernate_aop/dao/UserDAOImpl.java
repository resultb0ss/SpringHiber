package com.kaz.spring.mvc_hibernate_aop.dao;

import com.kaz.spring.mvc_hibernate_aop.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String CREATE_USERS_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS users(
                id int NOT NULL AUTO_INCREMENT,
                name varchar(25),
                surname varchar(25),
                department varchar(25),
                salary int,
                PRIMARY KEY (id)
            );
            """;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {
        entityManager.createNativeQuery(CREATE_USERS_TABLE_SQL).executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {

        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveNewUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {

        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUserById(int id) {

        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
