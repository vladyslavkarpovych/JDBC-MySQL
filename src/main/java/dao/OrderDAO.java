package dao;

import entities.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    void addOrder(Order product) throws SQLException;

    List<Order> getAllOrders() throws SQLException;

    Order getOrderByUserID(Integer userID) throws SQLException;

    void updateOrder(Order order) throws SQLException;

    void removeOrder(Order order) throws SQLException;
}
