package service;

import entities.BankcardEntity;
import entities.OrderoEntity;
import entities.ShoppingcartEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class OrderServiceHibernate {
    public OrderServiceHibernate() {
    }

    private static SessionFactory sessionFactory;
    private static final Date date = new Date();

    public void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addOrder(int userId, int productId, String orderStatus, float orderSubtotal, float orderTax, float orderDiscount,
                         float orderShipping, float orderTotal, String userName, String userSurname, String userPhoneNumber, String userAddress,
                         String userEmail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        OrderoEntity orderoEntity = new OrderoEntity(userId, productId, orderStatus, orderSubtotal, orderTax, orderDiscount,
                orderShipping, orderTotal, userName, userSurname, userPhoneNumber, userAddress, userEmail);
        session.save(orderoEntity);
        transaction.commit();
        session.close();
    }

    public List<OrderoEntity> orderList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<OrderoEntity> bankcardEntityList = session.createQuery("FROM OrderoEntity ").list();

        transaction.commit();
        session.close();
        return bankcardEntityList;
    }

    public OrderoEntity getOrderById(int orderId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        OrderoEntity orderoEntity = session.get(OrderoEntity.class, orderId);
        session.save(orderoEntity);
        transaction.commit();
        session.close();
        return orderoEntity;
    }

    public void updateOrder(int orderId, int userId, int productId, String orderStatus, float orderSubtotal, float orderTax, float orderDiscount,
                            float orderShipping, float orderTotal, String userName, String userSurname, String userPhoneNumber, String userAddress,
                            String userEmail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        OrderoEntity orderoEntity = session.get(OrderoEntity.class, orderId);
        orderoEntity.setUserId(userId);
        orderoEntity.setProductId(productId);
        orderoEntity.setOrderStatus(orderStatus);
        orderoEntity.setOrderSubtotal(orderSubtotal);
        orderoEntity.setOrderTax(orderTax);
        orderoEntity.setOrderDiscount(orderDiscount);
        orderoEntity.setOrderShipping(orderShipping);
        orderoEntity.setOrderTotal(orderTotal);
        orderoEntity.setUserName(userName);
        orderoEntity.setUserSurname(userSurname);
        orderoEntity.setUserPhoneNumber(userPhoneNumber);
        orderoEntity.setUserAddress(userAddress);
        orderoEntity.setUserEmail(userEmail);

        session.update(orderoEntity);
        transaction.commit();
        session.close();
    }

    public void removeOrder(int orderId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        OrderoEntity orderoEntity = session.get(OrderoEntity.class, orderId);
        session.delete(orderoEntity);
        transaction.commit();
        session.close();
    }
}
