package service;

import entities.ProductEntity;
import entities.ShoppingcartEntity;
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

public class ProductServiceTest {
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
    void addProduct() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Mozart");
        productEntity.setProductCategory("dessert");
        productEntity.setProductPrice(30);
        int id = (int) session.save(productEntity);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 1);
    }

    @Test
    void getAllProducts() {
        Session session = sessionFactory.openSession();
        Query<ProductEntity> productEntityQuery = session.createQuery("FROM ProductEntity", ProductEntity.class);
        List<ProductEntity> resultList = productEntityQuery.getResultList();
        Assertions.assertFalse(resultList.isEmpty());
    }

    @Test
    void getProductById() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        int id = 2;
        ProductEntity productEntity = session.find(ProductEntity.class, id);
        Assertions.assertEquals("Margarita", productEntity.getProductName());
        Assertions.assertEquals("Pizza", productEntity.getProductCategory());
        Assertions.assertEquals(20, productEntity.getProductPrice());
    }

    @Test
    void updateProduct() {
        int id = 3;
        Session session = sessionFactory.openSession();
        ProductEntity productEntity = session.find(ProductEntity.class, id);
        productEntity.setProductName("Cheese");
        productEntity.setProductPrice(30);
        session.beginTransaction();
        session.update(productEntity);
        session.getTransaction().commit();
        ProductEntity updateProduct = session.find(ProductEntity.class, id);
        Assertions.assertEquals("Cheese", updateProduct.getProductName());
        Assertions.assertEquals(30, updateProduct.getProductPrice());
    }

    @Test
    void removeProduct() {
        int id = 10;
        Session session = sessionFactory.openSession();
        ProductEntity productEntity = session.find(ProductEntity.class, id);
        session.beginTransaction();
        session.remove(productEntity);
        session.getTransaction().commit();
        ProductEntity deleteProduct = session.find(ProductEntity.class, id);
        Assertions.assertNull(deleteProduct);
    }
}
