package service;

import dao.ShoppingCartDAO;
import entities.ShoppingCart;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService extends Util implements ShoppingCartDAO {
    private Connection connection = getConnection();

    @Override
    public void addShoppingCart(ShoppingCart shoppingcart) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO shoppingcart VALUES (?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, shoppingcart.getUserID());
            preparedStatement.setString(3, shoppingcart.getItemName());
            preparedStatement.setInt(4, shoppingcart.getItemQuantity());
            preparedStatement.setFloat(5, shoppingcart.getItemPrice());
            preparedStatement.setFloat(6, shoppingcart.getTotalPrice());
            preparedStatement.setTimestamp(7, shoppingcart.getCreatedAt());
            preparedStatement.executeUpdate();
            System.out.println("Shopping cart added successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        String sql = "SELECT * FROM shoppingcart";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setCartID(resultSet.getInt("cart_id"));
                shoppingCart.setUserID(resultSet.getInt("user_id"));
                shoppingCart.setItemName(resultSet.getString("item_name"));
                shoppingCart.setItemQuantity(resultSet.getInt("item_quantity"));
                shoppingCart.setItemPrice(resultSet.getFloat("item_price"));
                shoppingCart.setTotalPrice(resultSet.getFloat("total_price"));
                shoppingCart.setCreatedAt(resultSet.getTimestamp("created_at"));
                shoppingCartList.add(shoppingCart);

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(statement, connection);
        }
        return shoppingCartList;
    }

    @Override
    public List<ShoppingCart> getShoppingCartByCartID(Integer cartId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM shoppingcart WHERE cart_id = ?";
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            shoppingCart.setCartID(resultSet.getInt("cart_id"));
            shoppingCart.setUserID(resultSet.getInt("user_id"));
            shoppingCart.setItemName(resultSet.getString("item_name"));
            shoppingCart.setItemQuantity(resultSet.getInt("item_quantity"));
            shoppingCart.setItemPrice(resultSet.getFloat("item_price"));
            shoppingCart.setTotalPrice(resultSet.getFloat("total_price"));
            shoppingCart.setCreatedAt(resultSet.getTimestamp("created_at"));
            preparedStatement.executeQuery();
            shoppingCartList.add(shoppingCart);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
        return shoppingCartList;
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingcart) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE shoppingcart SET user_id = ?, item_name = ?, item_quantity = ?, item_price = ?, total_price = ?, created_at = ? WHERE cart_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoppingcart.getUserID());
            preparedStatement.setString(2, shoppingcart.getItemName());
            preparedStatement.setInt(3, shoppingcart.getItemQuantity());
            preparedStatement.setFloat(4, shoppingcart.getItemPrice());
            preparedStatement.setFloat(5, shoppingcart.getTotalPrice());
            preparedStatement.setTimestamp(6, shoppingcart.getCreatedAt());
            preparedStatement.setInt(7, shoppingcart.getCartID());
            preparedStatement.executeUpdate();
            System.out.println("Shopping cart updated successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void removeShoppingCart(ShoppingCart shoppingcart) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM shoppingcart WHERE cart_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoppingcart.getCartID());
            preparedStatement.executeUpdate();
            System.out.println("Shopping cart removed successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);

        }

    }
}
