package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void addProduct(Product product) {
         productRepo.save(product);

    }

    public CustomResponse getProductById(String productId){
        Optional<Product> existedProduct = productRepo.findById(productId);
        if (existedProduct.isEmpty()){
            new CustomResponse(HttpStatus.NOT_FOUND.value(), "unavailable",null);
        }
       return new CustomResponse(HttpStatus.OK.value(), "success",existedProduct);

    }

    public List<Product> getAllProducts() {
      return productRepo.findAll();


    }



}
