package service;

import entities.BankcardEntity;
import entities.OrderoEntity;
import entities.ShoppingcartEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class BankcardServiceHibernate {
    public BankcardServiceHibernate() {
    }

    private static SessionFactory sessionFactory;
    private static final Date date = new Date();

    public void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addBankcard(int userId, String bankcardNumber, String bankcardOwnerName,
                            String bankcardOwnerSurname, float balance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        BankcardEntity bankcardEntity = new BankcardEntity(userId, bankcardNumber, bankcardOwnerName, bankcardOwnerSurname, balance);
        session.save(bankcardEntity);
        transaction.commit();
        session.close();
    }

    public List<BankcardEntity> bankcardList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<BankcardEntity> bankcardEntityList = session.createQuery("FROM BankcardEntity ").list();

        transaction.commit();
        session.close();
        return bankcardEntityList;
    }

    public BankcardEntity getBankcardById(int bankcardId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        BankcardEntity bankcardEntity = session.get(BankcardEntity.class, bankcardId);
        session.save(bankcardEntity);
        transaction.commit();
        session.close();
        return bankcardEntity;
    }

    public void updateBankcard(int bankcardId, float balance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        BankcardEntity bankcardEntity = session.get(BankcardEntity.class, bankcardId);
        bankcardEntity.setBalance(balance);
        session.update(bankcardEntity);
        transaction.commit();
        session.close();
    }

    public void removeBankcard(int bankcardId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        BankcardEntity bankcardEntity = session.get(BankcardEntity.class, bankcardId);
        session.delete(bankcardEntity);
        transaction.commit();
        session.close();
    }
}
