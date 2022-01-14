package service;

import dao.BankcardDAO;
import entities.Bankcard;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankcardService extends Util implements BankcardDAO {
    private static Connection connection = getConnection();

    @Override
    public void addBankcard(Bankcard bankcard) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO bankcard VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, bankcard.getUserID());
            preparedStatement.setString(3, bankcard.getBankcardNumber());
            preparedStatement.setString(4, bankcard.getBankcardOwnerName());
            preparedStatement.setString(5, bankcard.getBankcardOwnerSurname());
            preparedStatement.setFloat(6, bankcard.getBalance());

            preparedStatement.executeUpdate();

            System.out.println("Bankcard added successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public List<Bankcard> getAllBankcards() {
        List<Bankcard> bankcardList = new ArrayList<>();
        String sql = "SELECT * FROM bankcard";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bankcard bankcard = new Bankcard();
                bankcard.setBankcardID(resultSet.getInt("bankcard_id"));
                bankcard.setUserID(resultSet.getInt("user_id"));
                bankcard.setBankcardNumber(resultSet.getString("bankcard_number"));
                bankcard.setBankcardOwnerName(resultSet.getString("bankcard_owner_name"));
                bankcard.setBankcardOwnerSurname(resultSet.getString("bankcard_owner_surname"));
                bankcard.setBalance(resultSet.getFloat("balance"));
                bankcardList.add(bankcard);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(statement, connection);
        }
        return bankcardList;
    }

    @Override
    public Bankcard getBankcardByUserID(Integer userId) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM bankcard WHERE user_id = ?";
        Bankcard bankcard = new Bankcard();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            bankcard.setBankcardID(resultSet.getInt("bankcard_id"));
            bankcard.setUserID(resultSet.getInt("user_id"));
            bankcard.setBankcardNumber(resultSet.getString("bankcard_number"));
            bankcard.setBankcardOwnerName(resultSet.getString("bankcard_owner_name"));
            bankcard.setBankcardOwnerSurname(resultSet.getString("bankcard_owner_surname"));
            bankcard.setBalance(resultSet.getFloat("balance"));
            preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
        return bankcard;
    }

    @Override
    public void updateBankcard(Bankcard bankcard) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE bankcard SET balance=? WHERE user_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setFloat(1, bankcard.getBalance());
            preparedStatement.setInt(2, bankcard.getUserID());

            preparedStatement.executeUpdate();
            System.out.println("Bankcard updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }

    @Override
    public void removeBankcard(Bankcard bankcard) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM bankcard WHERE bankcard_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bankcard.getBankcardID());
            preparedStatement.executeUpdate();
            System.out.println("Bankcard removed successfully");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            CloseUtils.closeResources(preparedStatement, connection);
        }
    }
}
