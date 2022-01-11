package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "shop", catalog = "")
public class ProductEntity {
    private int productId;
    private String productName;
    private String productCategory;
    private float productPrice;
    private Timestamp productCreatedAt;

    public ProductEntity() {
    }

    public ProductEntity(String productName, String productCategory, float productPrice, Timestamp productCreatedAt) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productCreatedAt = productCreatedAt;
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_category")
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Basic
    @Column(name = "product_price")
    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_created_at")
    public Timestamp getProductCreatedAt() {
        return productCreatedAt;
    }

    public void setProductCreatedAt(Timestamp productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && Double.compare(that.productPrice, productPrice) == 0 && Objects.equals(productName, that.productName) && Objects.equals(productCategory, that.productCategory) && Objects.equals(productCreatedAt, that.productCreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productCategory, productPrice, productCreatedAt);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                ", productCreatedAt=" + productCreatedAt +
                '}';
    }
}
