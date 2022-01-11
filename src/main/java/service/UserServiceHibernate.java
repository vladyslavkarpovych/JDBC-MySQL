package service;

import entities.ProductEntity;
import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserServiceHibernate {
    public UserServiceHibernate() {
    }

    private static SessionFactory sessionFactory;
    private static final Date date = new Date();

    public void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addUser(String userName, String userSurname, int userAge, String sex,
                        String phoneNumber, String email, Timestamp registrationDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        UserEntity userEntity = new UserEntity(userName, userSurname, userAge, sex, phoneNumber, email, registrationDate);
        session.save(userEntity);
        transaction.commit();
        session.close();
    }

    public List<UserEntity> userList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<UserEntity> userList = session.createQuery("FROM UserEntity").list();

        transaction.commit();
        session.close();
        return userList;
    }

    public void updateUser(int userId, String userName, String userSurname, int userAge, String sex,
                           String phoneNumber, String email, Timestamp registrationDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, userId);
        userEntity.setUserName(userName);
        userEntity.setUserSurname(userSurname);
        userEntity.setUserAge(userAge);
        userEntity.setUserSex(sex);
        userEntity.setUserPhoneNumber(phoneNumber);
        userEntity.setUserEmail(email);
        userEntity.setUserRegistrationDate(registrationDate);
        session.update(userEntity);
        transaction.commit();
        session.close();
    }

    public UserEntity getUserById(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        UserEntity userEntity = session.get(UserEntity.class, userId);
        session.save(userEntity);
        transaction.commit();
        session.close();
        return userEntity;
    }

    public void removeUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, userId);
        session.delete(userEntity);
        transaction.commit();
        session.close();
    }

}
