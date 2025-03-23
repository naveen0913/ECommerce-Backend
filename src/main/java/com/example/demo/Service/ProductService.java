package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<?> addProduct(Product product) {
         productRepo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse(HttpStatus.CREATED.value(), "created",product));

    }

    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(),"available", productRepo.findAll()));


    }



}
