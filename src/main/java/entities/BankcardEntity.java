package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bankcard", schema = "shop", catalog = "")
public class BankcardEntity {
    private int bankcardId;
    private int userId;
    private String bankcardNumber;
    private String bankcardOwnerName;
    private String bankcardOwnerSurname;
    private double balance;

    public BankcardEntity() {
    }

    public BankcardEntity(int userId, String bankcardNumber, String bankcardOwnerName, String bankcardOwnerSurname, double balance) {
        this.userId = userId;
        this.bankcardNumber = bankcardNumber;
        this.bankcardOwnerName = bankcardOwnerName;
        this.bankcardOwnerSurname = bankcardOwnerSurname;
        this.balance = balance;
    }

    @Id
    @Column(name = "bankcard_id")
    public int getBankcardId() {
        return bankcardId;
    }

    public void setBankcardId(int bankcardId) {
        this.bankcardId = bankcardId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "bankcard_number")
    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    @Basic
    @Column(name = "bankcard_owner_name")
    public String getBankcardOwnerName() {
        return bankcardOwnerName;
    }

    public void setBankcardOwnerName(String bankcardOwnerName) {
        this.bankcardOwnerName = bankcardOwnerName;
    }

    @Basic
    @Column(name = "bankcard_owner_surname")
    public String getBankcardOwnerSurname() {
        return bankcardOwnerSurname;
    }

    public void setBankcardOwnerSurname(String bankcardOwnerSurname) {
        this.bankcardOwnerSurname = bankcardOwnerSurname;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankcardEntity that = (BankcardEntity) o;
        return bankcardId == that.bankcardId && userId == that.userId && Double.compare(that.balance, balance) == 0 && Objects.equals(bankcardNumber, that.bankcardNumber) && Objects.equals(bankcardOwnerName, that.bankcardOwnerName) && Objects.equals(bankcardOwnerSurname, that.bankcardOwnerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankcardId, userId, bankcardNumber, bankcardOwnerName, bankcardOwnerSurname, balance);
    }

    @Override
    public String toString() {
        return "BankcardEntity{" +
                "bankcardId=" + bankcardId +
                ", userId=" + userId +
                ", bankcardNumber='" + bankcardNumber + '\'' +
                ", bankcardOwnerName='" + bankcardOwnerName + '\'' +
                ", bankcardOwnerSurname='" + bankcardOwnerSurname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
