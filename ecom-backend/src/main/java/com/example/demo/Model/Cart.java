package com.example.demo.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
@Table(name = "cart-items")
public class Cart {
    @UuidGenerator
    @Id
    private String cartId;

    private int quantity;

    private String size;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)  // Foreign key for Product
    private Product product;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
