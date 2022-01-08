package dao;

import entities.Bankcard;
import java.sql.SQLException;
import java.util.List;

public interface BankcardDAO {
    void addBankcard(Bankcard bankcard) throws SQLException;

    List<Bankcard> getAllBankcards() throws SQLException;

    Bankcard getBankcardByUserID(Integer userId) throws SQLException;

    void updateBankcard(Bankcard bankcard) throws SQLException;

    void removeBankcard(Bankcard bankcard) throws SQLException;
}
