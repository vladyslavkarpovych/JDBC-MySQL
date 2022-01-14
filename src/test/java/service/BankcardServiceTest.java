package service;

import entities.BankcardEntity;
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
import java.util.List;

public class BankcardServiceTest {
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
    void addBankcard() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        BankcardEntity bankcardEntity = new BankcardEntity();
        bankcardEntity.setUserId(3);
        bankcardEntity.setBankcardNumber("4469014125");
        bankcardEntity.setBankcardOwnerName("John");
        bankcardEntity.setBankcardOwnerSurname("Kennedy");
        int id = (int) session.save(bankcardEntity);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 1);
    }

    @Test
    void getAllBankcards() {
        Session session = sessionFactory.openSession();
        Query<BankcardEntity> bankcardEntityQuery = session.createQuery("FROM BankcardEntity", BankcardEntity.class);
        List<BankcardEntity> resultList = bankcardEntityQuery.getResultList();
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void getBankcardById() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        int id = 1;
        BankcardEntity bankcardEntity = session.find(BankcardEntity.class, id);
        Assertions.assertEquals(2, bankcardEntity.getUserId());
        Assertions.assertEquals("Artur", bankcardEntity.getBankcardOwnerName());
        Assertions.assertEquals("Niklewicz", bankcardEntity.getBankcardOwnerSurname());
    }

    @Test
    void updateBankcard() {
        int id = 3;
        Session session = sessionFactory.openSession();
        BankcardEntity bankcardEntity = session.find(BankcardEntity.class, id);
        bankcardEntity.setBalance(10000);
        bankcardEntity.setBankcardOwnerName("Anna");
        bankcardEntity.setBankcardOwnerSurname("Mazur");
        session.beginTransaction();
        session.update(bankcardEntity);
        session.getTransaction().commit();
        BankcardEntity updateBankcard = session.find(BankcardEntity.class, id);
        Assertions.assertEquals(10000, updateBankcard.getBalance());
        Assertions.assertEquals("Anna", updateBankcard.getBankcardOwnerName());
        Assertions.assertEquals("Mazur", updateBankcard.getBankcardOwnerSurname());
    }

    @Test
    void removeBankcard() {
        int id = 5;
        Session session = sessionFactory.openSession();
        BankcardEntity bankcardEntity = session.find(BankcardEntity.class, id);
        session.beginTransaction();
        session.remove(bankcardEntity);
        session.getTransaction().commit();
        BankcardEntity deleteBankcard = session.find(BankcardEntity.class, id);
        Assertions.assertNull(deleteBankcard);
    }
}
