package service;

import dao.UserDAO;
import entities.User;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService extends Util implements UserDAO {

    Connection connection = getConnection();

    @Override
    public void addUser(User user) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserSurname());
            preparedStatement.setInt(4, user.getUserAge());
            preparedStatement.setString(5, user.getUserSex());
            preparedStatement.setString(6, user.getUserPhoneNumber());
            preparedStatement.setString(7, user.getUserEmail());
            preparedStatement.setTimestamp(8, user.getRegistrationDate());

            preparedStatement.executeUpdate();
            System.out.println("User added successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserSurname(resultSet.getString("user_surname"));
                user.setUserAge(resultSet.getInt("user_age"));
                user.setUserSex(resultSet.getString("user_sex"));
                user.setUserPhoneNumber(resultSet.getString("user_phone_number"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setRegistrationDate(resultSet.getTimestamp("user_registration_date"));

                userList.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(statement, connection);
        }
        return userList;
    }

    @Override
    public User getUserByID(Integer userId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM user WHERE user_id = ?";
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setUserID(resultSet.getInt("user_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setUserSurname(resultSet.getString("user_surname"));
            user.setUserAge(resultSet.getInt("user_age"));
            user.setUserSex(resultSet.getString("user_sex"));
            user.setUserPhoneNumber(resultSet.getString("user_phone_number"));
            user.setUserEmail(resultSet.getString("user_email"));
            user.setRegistrationDate(resultSet.getTimestamp("user_registration_date"));
            preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE user SET user_name = ?, user_surname = ?, user_age = ?, user_sex = ?, " +
                "user_phone_number = ?, user_email = ?, user_registration_date = ? WHERE user_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserSurname());
            preparedStatement.setInt(3, user.getUserAge());
            preparedStatement.setString(4, user.getUserSex());
            preparedStatement.setString(5, user.getUserPhoneNumber());
            preparedStatement.setString(6, user.getUserEmail());
            preparedStatement.setTimestamp(7, user.getRegistrationDate());
            preparedStatement.setInt(8, user.getUserID());

            preparedStatement.executeUpdate();
            System.out.println("User updated successfully ");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void removeUser(User user) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM user WHERE user_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.executeUpdate();
            System.out.println("User removed successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }
}