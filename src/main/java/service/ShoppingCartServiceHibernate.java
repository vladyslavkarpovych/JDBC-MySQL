package service;

import entities.ShoppingcartEntity;
import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ShoppingCartServiceHibernate {
    public ShoppingCartServiceHibernate() {
    }

    private static SessionFactory sessionFactory;
    private static final Date date = new Date();

    public void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addShoppingCart(int userId, String itemName, int itemQuantity, float itemPrice,
                                float totalPrice, Timestamp createdAt) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ShoppingcartEntity shoppingcartEntity = new ShoppingcartEntity(userId, itemName, itemQuantity, itemPrice, totalPrice, createdAt);
        session.save(shoppingcartEntity);
        transaction.commit();
        session.close();
    }

    public List<ShoppingcartEntity> shoppingCartList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<ShoppingcartEntity> shoppingCartEntityList = session.createQuery("FROM ShoppingcartEntity ").list();

        transaction.commit();
        session.close();
        return shoppingCartEntityList;
    }

    public ShoppingcartEntity getShoppingCartById(int cartId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        ShoppingcartEntity shoppingcartEntity = session.get(ShoppingcartEntity.class, cartId);
        session.save(shoppingcartEntity);
        transaction.commit();
        session.close();
        return shoppingcartEntity;
    }

    public void updateShoppingCart(int cartId, int userId, String itemName, int itemQuantity, float itemPrice,
                                   float totalPrice, Timestamp createdAt) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ShoppingcartEntity shoppingcartEntity = session.get(ShoppingcartEntity.class, cartId);
        shoppingcartEntity.setUserId(userId);
        shoppingcartEntity.setItemName(itemName);
        shoppingcartEntity.setItemQuantity(itemQuantity);
        shoppingcartEntity.setItemPrice(itemPrice);
        shoppingcartEntity.setTotalPrice(totalPrice);
        shoppingcartEntity.setCreatedAt(createdAt);
        session.update(shoppingcartEntity);
        transaction.commit();
        session.close();
    }

    public void removeShoppingCart(int cartId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ShoppingcartEntity shoppingcartEntity = session.get(ShoppingcartEntity.class, cartId);
        session.delete(shoppingcartEntity);
        transaction.commit();
        session.close();
    }
}
