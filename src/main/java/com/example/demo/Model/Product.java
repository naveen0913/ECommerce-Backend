package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.repository.Temporal;

import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @UuidGenerator
    @Id
    private String id;

    private String name;

    private String image1;

    private String image2;

    private String  offerPrice;

    private String price;

    private String categoryName;

    private String subCategory;

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    private String brandName;

    private Boolean s_size;

    private Boolean m_size;

    private Boolean l_size;

    private Boolean xl_size;

    private Boolean xxl_size;

    private int quantity;

    private int s_quantity;

    private int m_quantity;

    private int l_quantity;

    private int xl_quantity;

    private int xxl_quantity;

    private int ratings;
    private Double review;

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    private String fit;

    private Date created = new Date();


    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Double getReview() {
        return review;
    }

    public void setReview(Double review) {
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getS_quantity() {
        return s_quantity;
    }

    public void setS_quantity(int s_quantity) {
        this.s_quantity = s_quantity;
    }

    public int getM_quantity() {
        return m_quantity;
    }

    public void setM_quantity(int m_quantity) {
        this.m_quantity = m_quantity;
    }

    public int getL_quantity() {
        return l_quantity;
    }

    public void setL_quantity(int l_quantity) {
        this.l_quantity = l_quantity;
    }

    public int getXl_quantity() {
        return xl_quantity;
    }

    public void setXl_quantity(int xl_quantity) {
        this.xl_quantity = xl_quantity;
    }

    public int getXxl_quantity() {
        return xxl_quantity;
    }

    public void setXxl_quantity(int xxl_quantity) {
        this.xxl_quantity = xxl_quantity;
    }

    public Date getCreated() {
        return created;
    }

    public Boolean getS_size() {
        return s_size;
    }

    public void setS_size(Boolean s_size) {
        this.s_size = s_size;
    }

    public Boolean getM_size() {
        return m_size;
    }

    public void setM_size(Boolean m_size) {
        this.m_size = m_size;
    }

    public Boolean getL_size() {
        return l_size;
    }

    public void setL_size(Boolean l_size) {
        this.l_size = l_size;
    }

    public Boolean getXl_size() {
        return xl_size;
    }

    public void setXl_size(Boolean xl_size) {
        this.xl_size = xl_size;
    }

    public Boolean getXxl_size() {
        return xxl_size;
    }

    public void setXxl_size(Boolean xxl_size) {
        this.xxl_size = xxl_size;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
