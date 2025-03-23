package com.example.demo.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @UuidGenerator
    @Id
    private String wishlisId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Linking Wishlist to User
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)  // Linking Wishlist to Product
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public String getWishlisId() {
        return wishlisId;
    }

    public void setWishlisId(String wishlisId) {
        this.wishlisId = wishlisId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
