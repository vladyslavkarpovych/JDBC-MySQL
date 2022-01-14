package service;

import entities.OrderoEntity;
import entities.ProductEntity;
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
import java.util.Locale;

public class OrderServiceTest {
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
    void addOrder() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        OrderoEntity orderoEntity = new OrderoEntity();
        orderoEntity.setUserId(2);
        orderoEntity.setProductId(5);
        orderoEntity.setOrderStatus("PAID");
        orderoEntity.setOrderSubtotal(30);
        orderoEntity.setOrderTax(3);
        orderoEntity.setOrderDiscount(5);
        orderoEntity.setOrderShipping(3);
        orderoEntity.setOrderTotal(38);
        orderoEntity.setUserName("Dmytro");
        orderoEntity.setUserSurname("Karpovych");
        orderoEntity.setUserPhoneNumber("+48024212531");
        orderoEntity.setUserEmail("dmytro@gmail.com");

        int id = (int) session.save(orderoEntity);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 1);
    }

    @Test
    void getAllOrders() {
        Session session = sessionFactory.openSession();
        Query<OrderoEntity> orderoEntity = session.createQuery("FROM OrderoEntity", OrderoEntity.class);
        List<OrderoEntity> resultList = orderoEntity.getResultList();
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void getOrderById() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        int id = 6;
        OrderoEntity orderoEntity = session.find(OrderoEntity.class, id);
        Assertions.assertEquals(2, orderoEntity.getUserId());
        Assertions.assertEquals(5, orderoEntity.getProductId());
        Assertions.assertEquals("paid".toUpperCase(Locale.ROOT), orderoEntity.getOrderStatus());
    }

    @Test
    void updateOrder() {
        int id = 6;
        Session session = sessionFactory.openSession();
        OrderoEntity orderoEntity = session.find(OrderoEntity.class, id);
        orderoEntity.setOrderStatus("DELIVERED");
        orderoEntity.setUserId(6);
        session.beginTransaction();
        session.update(orderoEntity);
        session.getTransaction().commit();
        OrderoEntity updateOrder = session.find(OrderoEntity.class, id);
        Assertions.assertEquals("DELIVERED", updateOrder.getOrderStatus());
        Assertions.assertEquals(6, updateOrder.getUserId());
    }

    @Test
    void removeOrder() {
        int id = 6;
        Session session = sessionFactory.openSession();
        OrderoEntity orderoEntity = session.find(OrderoEntity.class, id);
        session.beginTransaction();
        session.remove(orderoEntity);
        session.getTransaction().commit();
        OrderoEntity deleteOrder = session.find(OrderoEntity.class, id);
        Assertions.assertNull(deleteOrder);
    }
}
