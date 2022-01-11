package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "shop")
public class UserEntity {
    private int userId;
    private String userName;
    private String userSurname;
    private int userAge;
    private String userSex;
    private String userPhoneNumber;
    private String userEmail;
    private Timestamp userRegistrationDate;

    public UserEntity() {}

    public UserEntity(String userName, String userSurname, int userAge, String userSex, String userPhoneNumber, String userEmail, Timestamp userRegistrationDate) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userRegistrationDate = userRegistrationDate;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_surname")
    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    @Basic
    @Column(name = "user_age")
    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_phone_number")
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_registration_date")
    public Timestamp getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Timestamp userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && userAge == that.userAge && Objects.equals(userName, that.userName) && Objects.equals(userSurname, that.userSurname) && Objects.equals(userSex, that.userSex) && Objects.equals(userPhoneNumber, that.userPhoneNumber) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userRegistrationDate, that.userRegistrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, userAge, userSex, userPhoneNumber, userEmail, userRegistrationDate);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegistrationDate=" + userRegistrationDate +
                '}';
    }
}
