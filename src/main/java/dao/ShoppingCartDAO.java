package dao;

import entities.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartDAO {
    void addShoppingCart(ShoppingCart shoppingcart) throws SQLException;

    List<ShoppingCart> getAllShoppingCarts() throws SQLException;

    List<ShoppingCart> getShoppingCartByCartID(Integer userId) throws SQLException;

    void updateShoppingCart(ShoppingCart shoppingcart) throws SQLException;

    void removeShoppingCart(ShoppingCart shoppingcart) throws SQLException;
}
