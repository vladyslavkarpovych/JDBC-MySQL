package service;

import dao.OrderDAO;
import entities.Order;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService extends Util implements OrderDAO {
    private Connection connection = getConnection();

    @Override
    public void addOrder(Order order) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ordero VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, order.getUserID());
            preparedStatement.setInt(3, order.getProductID());
            preparedStatement.setString(4, order.getOrderStatus());
            preparedStatement.setFloat(5, order.getOrderSubtotal());
            preparedStatement.setFloat(6, order.getOrderTax());
            preparedStatement.setFloat(7, order.getOrderDiscount());
            preparedStatement.setFloat(8, order.getOrderShipping());
            preparedStatement.setFloat(9, order.getOrderTotal());
            preparedStatement.setString(10, order.getUserName());
            preparedStatement.setString(11, order.getUserSurname());
            preparedStatement.setString(12, order.getUserPhoneNumber());
            preparedStatement.setString(13, order.getUserAddress());
            preparedStatement.setString(14, order.getUserEmail());
            preparedStatement.executeUpdate();
            System.out.println("Order added successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);

        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM ordero";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("order_id"));
                order.setUserID(resultSet.getInt("user_id"));
                order.setProductID(resultSet.getInt("product_id"));
                order.setOrderStatus(resultSet.getString("order_status"));
                order.setOrderSubtotal(resultSet.getFloat("order_subtotal"));
                order.setOrderTax(resultSet.getFloat("order_tax"));
                order.setOrderDiscount(resultSet.getFloat("order_discount"));
                order.setOrderShipping(resultSet.getFloat("order_shipping"));
                order.setOrderTotal(resultSet.getFloat("order_total"));
                order.setUserName(resultSet.getString("user_name"));
                order.setUserSurname(resultSet.getString("user_surname"));
                order.setUserPhoneNumber(resultSet.getString("user_phone_number"));
                order.setUserAddress(resultSet.getString("user_address"));
                order.setUserEmail(resultSet.getString("user_email"));
                orderList.add(order);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(statement, connection);
        }
        return orderList;
    }

    @Override
    public Order getOrderByUserID(Integer userID) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM ordero WHERE user_id = ?";
        Order order = new Order();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            order.setOrderID(resultSet.getInt("order_id"));
            order.setUserID(resultSet.getInt("user_id"));
            order.setProductID(resultSet.getInt("product_id"));
            order.setOrderStatus(resultSet.getString("order_status"));
            order.setOrderSubtotal(resultSet.getFloat("order_subtotal"));
            order.setOrderTax(resultSet.getFloat("order_tax"));
            order.setOrderDiscount(resultSet.getFloat("order_discount"));
            order.setOrderShipping(resultSet.getFloat("order_shipping"));
            order.setOrderTotal(resultSet.getFloat("order_total"));
            order.setUserName(resultSet.getString("user_name"));
            order.setUserSurname(resultSet.getString("user_surname"));
            order.setUserPhoneNumber(resultSet.getString("user_phone_number"));
            order.setUserAddress(resultSet.getString("user_address"));
            order.setUserEmail(resultSet.getString("user_email"));
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ordero SET user_id = ?, product_id = ?, order_status = ?, order_subtotal = ?, order_tax = ?, " +
                "order_discount = ?, order_shipping = ?, order_total = ?, user_name = ?, user_surname = ?, user_phone_number = ?, user_address = ?, user_email = ? WHERE order_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getUserID());
            preparedStatement.setInt(2, order.getProductID());
            preparedStatement.setString(3, order.getOrderStatus());
            preparedStatement.setFloat(4, order.getOrderSubtotal());
            preparedStatement.setFloat(5, order.getOrderTax());
            preparedStatement.setFloat(6, order.getOrderDiscount());
            preparedStatement.setFloat(7, order.getOrderShipping());
            preparedStatement.setFloat(8, order.getOrderTotal());
            preparedStatement.setString(9, order.getUserName());
            preparedStatement.setString(10, order.getUserSurname());
            preparedStatement.setString(11, order.getUserPhoneNumber());
            preparedStatement.setString(12, order.getUserAddress());
            preparedStatement.setString(13, order.getUserEmail());
            preparedStatement.setInt(14, order.getOrderID());
            preparedStatement.executeUpdate();
            System.out.println("Order updated successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void removeOrder(Order order) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ordero WHERE order_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getOrderID());
            preparedStatement.executeUpdate();
            System.out.println("Order removed successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }
}
