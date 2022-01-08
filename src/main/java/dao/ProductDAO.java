package dao;

import entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void addProduct(Product product) throws SQLException;

    List<Product> getAllProducts() throws SQLException;

    Product getProductByID(Integer productId) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void removeProduct(Product product) throws SQLException;
}
