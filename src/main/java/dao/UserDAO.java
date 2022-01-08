package dao;

import entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    User getUserByID(Integer userId) throws SQLException;

    void updateUser(User user) throws SQLException;

    void removeUser(User user) throws SQLException;
}
