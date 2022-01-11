package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart", schema = "shop")
public class ShoppingcartEntity {
    private int cartId;
    private int userId;
    private String itemName;
    private Integer itemQuantity;
    private Float itemPrice;
    private Float totalPrice;
    private Timestamp createdAt;

    public ShoppingcartEntity(int userId, String itemName, Integer itemQuantity, Float itemPrice, Float totalPrice, Timestamp createdAt) {
        this.userId = userId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public ShoppingcartEntity() {}

    @Id
    @Column(name = "cart_id")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cardId) {
        this.cartId = cardId;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    @Column(name = "item_price")
    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_quantity")
    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Basic
    @Column(name = "total_price")
    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartEntity that = (ShoppingcartEntity) o;
        return cartId == that.cartId && Objects.equals(itemName, that.itemName) && Objects.equals(itemQuantity, that.itemQuantity) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, itemName, itemQuantity, totalPrice, createdAt);
    }

    @Override
    public String toString() {
        return "ShoppingcartEntity{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemPrice=" + itemPrice +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}
