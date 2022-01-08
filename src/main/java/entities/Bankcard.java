package entities;

import java.util.Objects;

public class Bankcard {
    private Integer bankcardID;
    private Integer userID;
    private String bankcardNumber;
    private String bankcardOwnerName;
    private String bankcardOwnerSurname;
    private Float balance;

    public Bankcard(){}

    public Integer getBankcardID() {
        return bankcardID;
    }

    public void setBankcardID(Integer bankcardID) {
        this.bankcardID = bankcardID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getBankcardOwnerName() {
        return bankcardOwnerName;
    }

    public void setBankcardOwnerName(String bankcardOwnerName) {
        this.bankcardOwnerName = bankcardOwnerName;
    }

    public String getBankcardOwnerSurname() {
        return bankcardOwnerSurname;
    }

    public void setBankcardOwnerSurname(String bankcardOwnerSurname) {
        this.bankcardOwnerSurname = bankcardOwnerSurname;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bankcard bankcard = (Bankcard) o;
        return Objects.equals(bankcardID, bankcard.bankcardID) && Objects.equals(userID, bankcard.userID) && Objects.equals(bankcardNumber, bankcard.bankcardNumber) && Objects.equals(bankcardOwnerName, bankcard.bankcardOwnerName) && Objects.equals(bankcardOwnerSurname, bankcard.bankcardOwnerSurname) && Objects.equals(balance, bankcard.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankcardID, userID, bankcardNumber, bankcardOwnerName, bankcardOwnerSurname, balance);
    }

    @Override
    public String toString() {
        return "Bankcard{" +
                "bankcardID=" + bankcardID +
                ", userID=" + userID +
                ", bankcardNumber='" + bankcardNumber + '\'' +
                ", bankcardOwnerName='" + bankcardOwnerName + '\'' +
                ", bankcardOwnerSurname='" + bankcardOwnerSurname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
