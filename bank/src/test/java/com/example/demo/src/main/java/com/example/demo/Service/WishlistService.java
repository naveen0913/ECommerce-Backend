package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Model.Wishlist;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Repository.WishlistRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    WishlistRepo wishlistRepo;

    public void addWishlistItem(String userId,String productId){
        Optional<User> existedUser = userRepo.findById(userId);
        Optional<Product> existedProduct = productRepo.findById(productId);
        if (existedUser.isEmpty()){
            new CustomResponse(HttpStatus.NOT_FOUND.value(),"user not found",null);
        }
        if (existedProduct.isEmpty()){
            new CustomResponse(HttpStatus.NOT_FOUND.value(),"product not found",null);
        }
        Wishlist newItem = new Wishlist();
        newItem.setUser(existedUser.get());
        newItem.setProduct(existedProduct.get());
        wishlistRepo.save(newItem);
    }

    public List<Wishlist> getUserWishlist(String userId) {

        return wishlistRepo.getAllItemsByUser(userId);
    }

    public void removeFromWishlist(String wishlistId) {
        wishlistRepo.deleteById(wishlistId);
    }

}
