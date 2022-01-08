package entities;

import java.util.Objects;

public class Order {
    private Integer orderID;
    private Integer userID;
    private Integer productID;
    private String orderStatus;
    private Float orderSubtotal;
    private Float orderTax;
    private Float orderDiscount;
    private Float orderShipping;
    private Float orderTotal;
    private String userName;
    private String userSurname;
    private String userPhoneNumber;
    private String userAddress;
    private String userEmail;

    public Order(){}

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(Float orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public Float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(Float orderTax) {
        this.orderTax = orderTax;
    }

    public Float getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Float orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Float getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(Float orderShipping) {
        this.orderShipping = orderShipping;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

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
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID) && Objects.equals(userID, order.userID) && Objects.equals(productID, order.productID) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(orderSubtotal, order.orderSubtotal) && Objects.equals(orderTax, order.orderTax) && Objects.equals(orderDiscount, order.orderDiscount) && Objects.equals(orderShipping, order.orderShipping) && Objects.equals(orderTotal, order.orderTotal) && Objects.equals(userName, order.userName) && Objects.equals(userSurname, order.userSurname) && Objects.equals(userPhoneNumber, order.userPhoneNumber) && Objects.equals(userAddress, order.userAddress) && Objects.equals(userEmail, order.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, userID, productID, orderStatus, orderSubtotal, orderTax, orderDiscount, orderShipping, orderTotal, userName, userSurname, userPhoneNumber, userAddress, userEmail);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", productID=" + productID +
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
