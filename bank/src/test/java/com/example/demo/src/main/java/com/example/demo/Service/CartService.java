package com.example.demo.Service;

import com.example.demo.DTO.CartDTO;
import com.example.demo.Model.Cart;
import com.example.demo.Model.Product;
import com.example.demo.Repository.CartRepo;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    ProductRepo productRepo;

    public void addItemToCart(String productId,CartDTO cartDTO){
        Optional<Product> existedProduct = productRepo.findById(productId);
        if (existedProduct.isEmpty()){
             new CustomResponse(HttpStatus.NOT_FOUND.value(),"product not found",null);
        }
        Cart newCartItem = new Cart();
        newCartItem.setProduct(existedProduct.get());
        newCartItem.setQuantity(cartDTO.getQuantity());
        newCartItem.setSize(cartDTO.getSize());
        cartRepo.save(newCartItem);
//        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(),"item added to Cart",newCartItem));
    }

    // Get all cart items
    public List<Cart> getAllCartItems() {
        return cartRepo.findAll();
    }

    // Update Cart
    public ResponseEntity<?> updateCart(String cartId, CartDTO cartDTO) {
        Optional<Cart> cartOpt = cartRepo.findById(cartId);
        if (cartOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(HttpStatus.NOT_FOUND.value(),"Cart item not found",null));
        }

        Cart cartItem = cartOpt.get();
        cartItem.setQuantity(cartDTO.getQuantity());
        cartItem.setSize(cartDTO.getSize());
        cartRepo.save(cartItem);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(),"cart item updated",null));

    }

    public void deleteCartItem(String cartId) {
        cartRepo.deleteById(cartId);
    }


}
