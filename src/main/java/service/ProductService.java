package service;

import dao.ProductDAO;
import entities.Product;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {
    private Connection connection = getConnection();

    @Override
    public void addProduct(Product product) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO product VALUES (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductCategory());
            preparedStatement.setFloat(4, product.getPrice());
            preparedStatement.setTimestamp(5, product.getCreatedAt());
            preparedStatement.executeUpdate();
            System.out.println("Product added successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setProductCategory(resultSet.getString("product_category"));
                product.setPrice(resultSet.getFloat("product_price"));
                product.setCreatedAt(resultSet.getTimestamp("product_created_at"));

                productList.add(product);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(statement, connection);
        }
        return productList;
    }

    @Override
    public Product getProductByID(Integer productId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";
        Product product = new Product();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            product.setProductID(resultSet.getInt("product_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setProductCategory(resultSet.getString("product_category"));
            product.setPrice(resultSet.getFloat("product_price"));
            product.setCreatedAt(resultSet.getTimestamp("created_at"));
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);

        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE product SET product_name = ?, product_category = ?, product_price = ?, product_created_at = ? WHERE product_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductCategory());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setTimestamp(4, product.getCreatedAt());
            preparedStatement.setInt(5, product.getProductID());
            preparedStatement.executeUpdate();
            System.out.println("Product updated successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void removeProduct(Product product) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM product WHERE product_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductID());
            preparedStatement.executeUpdate();
            System.out.println("Product removed successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }
}
