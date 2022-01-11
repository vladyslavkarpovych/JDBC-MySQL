package service;

import entities.BankcardEntity;
import entities.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ProductServiceHibernate {
    public ProductServiceHibernate() {
    }

    private static SessionFactory sessionFactory;
    private static final Date date = new Date();

    public void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addProduct(String productName, String productCategory, float productPrice, Timestamp createdAt) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ProductEntity productEntity = new ProductEntity(productName, productCategory, productPrice, createdAt);
        session.save(productEntity);
        transaction.commit();
        session.close();
    }

    public List<ProductEntity> productEntityList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<ProductEntity> productEntityList = session.createQuery("FROM ProductEntity ").list();

        transaction.commit();
        session.close();
        return productEntityList;
    }

    public ProductEntity getProductById(int productId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        ProductEntity productEntity = session.get(ProductEntity.class, productId);
        session.save(productEntity);
        transaction.commit();
        session.close();
        return productEntity;
    }

    public void updateProductEntity(int productId, String productName, String productCategory, float productPrice, Timestamp createdAt) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ProductEntity productEntity = session.get(ProductEntity.class, productId);
        productEntity.setProductName(productName);
        productEntity.setProductCategory(productCategory);
        productEntity.setProductPrice(productPrice);
        productEntity.setProductCreatedAt(createdAt);
        session.update(productEntity);
        transaction.commit();
        session.close();
    }

    public void removeProduct(int productId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        ProductEntity productEntity = session.get(ProductEntity.class, productId);
        session.delete(productEntity);
        transaction.commit();
        session.close();
    }
}
