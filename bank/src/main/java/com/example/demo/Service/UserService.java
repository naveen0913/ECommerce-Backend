package com.example.demo.Service;

import com.example.demo.DTO.SignUpDTO;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepository;



//    public ResponseEntity<?> registerUser(SignUpDTO signUpDTO,boolean isAdmin) {
//        User existedUser = userRepository.findByUsername(signUpDTO.getEmail());
//        if (existedUser!=null){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(new CustomResponse(HttpStatus.CONFLICT.value(), "User already exists", null));
//        }
//        User newUser = new User();
//        newUser.setUsername(signUpDTO.getUsername());
//        newUser.setEmail(signUpDTO.getEmail());
//        newUser.setPassword(signUpDTO.getPassword());
//        newUser.setCreated(new Date());
//
//    }


}
