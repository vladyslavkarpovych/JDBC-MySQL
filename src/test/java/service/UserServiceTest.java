package service;

import entities.UserEntity;
import logic.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class UserServiceTest {
    private static SessionFactory sessionFactory;
    private Date date;

    @BeforeAll
    public static void setup() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("SessionFactory destroyed");
        }
    }

    @Test
    void addUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("Иван");
        userEntity.setUserSurname("Иванович");
        userEntity.setUserAge(33);
        userEntity.setUserSex("male");
        userEntity.setUserPhoneNumber("3115115125");
        userEntity.setUserEmail("iva@gmail.com");
        int id = (int) session.save(userEntity);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 1);
    }

    @Test
    void getAllUsers() {
        Session session = sessionFactory.openSession();
        Query<UserEntity> userEntityQuery = session.createQuery("FROM UserEntity", UserEntity.class);
        List<UserEntity> resultList = userEntityQuery.getResultList();
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void getUserById() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        int id = 6;
        UserEntity userEntity = session.find(UserEntity.class, id);
        Assertions.assertEquals("Liza", userEntity.getUserName());
    }

    @Test
    void updateUser() {
        int id = 5;
        Session session = sessionFactory.openSession();
        UserEntity userEntity = session.find(UserEntity.class, id);
        userEntity.setUserName("Klara");
        session.beginTransaction();
        session.update(userEntity);
        session.getTransaction().commit();
        UserEntity updateUser = session.find(UserEntity.class, id);
        Assertions.assertEquals("Klara", updateUser.getUserName());
    }

    @Test
    void removeUser() {
        int id = 12;
        Session session = sessionFactory.openSession();
        UserEntity userEntity = session.find(UserEntity.class, id);
        session.beginTransaction();
        session.remove(userEntity);
        session.getTransaction().commit();
        UserEntity deleteUser = session.find(UserEntity.class, id);
        Assertions.assertNull(deleteUser);
    }
}
