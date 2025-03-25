package com.example.demo.Controller;

import com.example.demo.DTO.CartDTO;
import com.example.demo.Response.CustomResponse;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable String productId,
                                       @RequestBody CartDTO cartDTO) {
         cartService.addItemToCart(productId,cartDTO);
         return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(),"item added to Cart",null));

    }

    @GetMapping("/all")
    public ResponseEntity<?> getALLCartItems(){
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(), "success", cartService.getAllCartItems()));
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<?> updateCartItem(@PathVariable String cartId,@RequestBody CartDTO cartDTO){
        return cartService.updateCart(cartId,cartDTO);

    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable String cartId) {
        cartService.deleteCartItem(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(),"deleted",null));
    }


}
