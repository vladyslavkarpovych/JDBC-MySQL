package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordero", schema = "shop")
public class OrderoEntity {
    private int orderId;
    private int userId;
    private int productId;
    private String orderStatus;
    private float orderSubtotal;
    private float orderTax;
    private float orderDiscount;
    private float orderShipping;
    private float orderTotal;
    private String userName;
    private String userSurname;
    private String userPhoneNumber;
    private String userAddress;
    private String userEmail;

    public OrderoEntity(int userId, int productId, String orderStatus, float orderSubtotal, float orderTax, float orderDiscount,
                        float orderShipping, float orderTotal, String userName, String userSurname, String userPhoneNumber,
                        String userAddress, String userEmail) {
        this.userId = userId;
        this.productId = productId;
        this.orderStatus = orderStatus;
        this.orderSubtotal = orderSubtotal;
        this.orderTax = orderTax;
        this.orderDiscount = orderDiscount;
        this.orderShipping = orderShipping;
        this.orderTotal = orderTotal;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }

    public OrderoEntity() {

    }

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_subtotal")
    public float getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(float orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    @Basic
    @Column(name = "order_tax")
    public float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(float orderTax) {
        this.orderTax = orderTax;
    }

    @Basic
    @Column(name = "order_discount")
    public float getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(float orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    @Basic
    @Column(name = "order_shipping")
    public float getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(float orderShipping) {
        this.orderShipping = orderShipping;
    }

    @Basic
    @Column(name = "order_total")
    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
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
    @Column(name = "user_phone_number")
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Basic
    @Column(name = "user_address")
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderoEntity that = (OrderoEntity) o;
        return orderId == that.orderId && Double.compare(that.orderSubtotal, orderSubtotal) == 0 && Double.compare(that.orderTax, orderTax) == 0 && Double.compare(that.orderDiscount, orderDiscount) == 0 && Double.compare(that.orderShipping, orderShipping) == 0 && orderTotal == that.orderTotal && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(userName, that.userName) && Objects.equals(userSurname, that.userSurname) && Objects.equals(userPhoneNumber, that.userPhoneNumber) && Objects.equals(userAddress, that.userAddress) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderStatus, orderSubtotal, orderTax, orderDiscount, orderShipping, orderTotal, userName, userSurname, userPhoneNumber, userAddress, userEmail);
    }

    @Override
    public String toString() {
        return "OrderoEntity{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderSubtotal=" + orderSubtotal +
                ", orderTax=" + orderTax +
                ", orderDiscount=" + orderDiscount +
                ", orderShipping=" + orderShipping +
                ", orderTotal=" + orderTotal +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
