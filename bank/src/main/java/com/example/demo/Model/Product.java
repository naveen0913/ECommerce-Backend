package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

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

    private String image3;

    private String image4;

    private String  offerPrice;

    private String price;

    private String  stockLevel;

    private String stock;

    private String categoryName;

    private String brandName;

    private String size1;

    private String size2;

    private String size3;

    private String size4;

    private int quantity;

    private int s_quantity;

    private int m_quantity;

    private int l_quantity;

    private int XL_quantity;

    private int XXL_quantity;

    private Date created;

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

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
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

    public String getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(String stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public String getSize1() {
        return size1;
    }

    public void setSize1(String size1) {
        this.size1 = size1;
    }

    public String getSize2() {
        return size2;
    }

    public void setSize2(String size2) {
        this.size2 = size2;
    }

    public String getSize3() {
        return size3;
    }

    public void setSize3(String size3) {
        this.size3 = size3;
    }

    public String getSize4() {
        return size4;
    }

    public void setSize4(String size4) {
        this.size4 = size4;
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

    public int getXL_quantity() {
        return XL_quantity;
    }

    public void setXL_quantity(int XL_quantity) {
        this.XL_quantity = XL_quantity;
    }

    public int getXXL_quantity() {
        return XXL_quantity;
    }

    public void setXXL_quantity(int XXL_quantity) {
        this.XXL_quantity = XXL_quantity;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
