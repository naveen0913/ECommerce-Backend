package com.example.demo.Controller;

import com.example.demo.Model.Wishlist;
import com.example.demo.Response.CustomResponse;
import com.example.demo.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin("*")
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    @PostMapping("/add/{userId}/{productId}")
    public ResponseEntity<?> addWishlistItem(@PathVariable String userId, @PathVariable String productId) {
        wishlistService.addWishlistItem(userId, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse(HttpStatus.CREATED.value(), "created", null));
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getALLWishlistItems(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(), "success", wishlistService.getUserWishlist(userId)));
    }

    @DeleteMapping("/del/{wishlistId}")
    public ResponseEntity<?> deleteWishlistItem(@PathVariable String wishlistId){
        wishlistService.removeFromWishlist(wishlistId);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(), "deleted", null));
    }


}