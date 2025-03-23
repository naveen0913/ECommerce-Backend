package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class CartDTO {
    @NotBlank
    private int quantity;
    @NotBlank
    private String size;

    @NotBlank
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotBlank int quantity) {
        this.quantity = quantity;
    }

    public @NotBlank String getSize() {
        return size;
    }

    public void setSize(@NotBlank String size) {
        this.size = size;
    }
}
