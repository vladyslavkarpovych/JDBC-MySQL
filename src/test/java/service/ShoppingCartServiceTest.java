package service;

import entities.ShoppingcartEntity;
import entities.UserEntity;
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

public class ShoppingCartServiceTest {
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
    void addShoppingCart() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ShoppingcartEntity shoppingcartEntity = new ShoppingcartEntity();
        shoppingcartEntity.setUserId(2);
        shoppingcartEntity.setItemName("Fanta");
        shoppingcartEntity.setItemQuantity(2);
        shoppingcartEntity.setItemPrice(8);
        shoppingcartEntity.setTotalPrice(10);
        int id = (int) session.save(shoppingcartEntity);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 1);
    }

    @Test
    void getAllShoppingCarts() {
        Session session = sessionFactory.openSession();
        Query<ShoppingcartEntity> shoppingcartEntityQuery = session.createQuery("FROM ShoppingcartEntity", ShoppingcartEntity.class);
        List<ShoppingcartEntity> resultList = shoppingcartEntityQuery.getResultList();
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void getShoppingCartById() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        int id = 2;
        ShoppingcartEntity shoppingcartEntity = session.find(ShoppingcartEntity.class, id);
        Assertions.assertEquals("Carbonara", shoppingcartEntity.getItemName());
        Assertions.assertEquals(3, shoppingcartEntity.getItemQuantity());
        Assertions.assertEquals(20, shoppingcartEntity.getItemPrice());
        Assertions.assertEquals(60, shoppingcartEntity.getTotalPrice());
    }

    @Test
    void updateShoppingCart() {
        int id = 3;
        Session session = sessionFactory.openSession();
        ShoppingcartEntity shoppingcartEntity = session.find(ShoppingcartEntity.class, id);
        shoppingcartEntity.setItemName("Alfreza");
        shoppingcartEntity.setItemQuantity(2);
        shoppingcartEntity.setItemPrice(20);
        shoppingcartEntity.setTotalPrice(40);
        session.beginTransaction();
        session.update(shoppingcartEntity);
        session.getTransaction().commit();
        ShoppingcartEntity updateShoppingCart = session.find(ShoppingcartEntity.class, id);
        Assertions.assertEquals("Alfreza", updateShoppingCart.getItemName());
        Assertions.assertEquals(2, updateShoppingCart.getItemQuantity());
        Assertions.assertEquals(20, updateShoppingCart.getItemPrice());
        Assertions.assertEquals(40, updateShoppingCart.getTotalPrice());
    }

    @Test
    void removeShoppingCart() {
        int id = 7;
        Session session = sessionFactory.openSession();
        ShoppingcartEntity shoppingcartEntity = session.find(ShoppingcartEntity.class, id);
        session.beginTransaction();
        session.remove(shoppingcartEntity);
        session.getTransaction().commit();
        ShoppingcartEntity deleteShoppingCart = session.find(ShoppingcartEntity.class, id);
        Assertions.assertNull(deleteShoppingCart);
    }
}
