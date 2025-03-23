package com.example.demo.Service;

import com.example.demo.DTO.LoginDTO;
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
import java.util.Optional;
import java.util.Set;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepository;

    public ResponseEntity<?> registerUser(SignUpDTO signUpDTO,boolean isAdmin) {
        Optional<User> existedUser = userRepository.findByEmail(signUpDTO.getEmail());
        if (existedUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new CustomResponse(HttpStatus.CONFLICT.value(), "User already exists", null));
        }
        User newUser = new User();
        newUser.setUsername(signUpDTO.getUsername());
        newUser.setEmail(signUpDTO.getEmail());
        newUser.setPassword(signUpDTO.getPassword());
        newUser.setCreated(new Date());
        String userRole = "user";
        newUser.setRole(userRole);
        userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse(HttpStatus.CREATED.value(), "created",null));
    }

    public ResponseEntity<?> userLogin(LoginDTO loginDTO){
        Optional<User> existedUser = userRepository.findByEmail(loginDTO.getEmail());
        if (existedUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(HttpStatus.NOT_FOUND.value(), "User not found", null));
        }
        if (!loginDTO.getEmail().equals(existedUser.get().getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(HttpStatus.NOT_FOUND.value(), "user does not existed with email",null));

        } else if (!loginDTO.getPassword().equals(existedUser.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomResponse(HttpStatus.BAD_REQUEST.value(), "incorrect password! try again",null));

        }
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(HttpStatus.OK.value(), "login success",existedUser));

    }


}
