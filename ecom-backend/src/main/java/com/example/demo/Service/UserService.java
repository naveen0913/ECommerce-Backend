package com.example.demo.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.SignUpDTO;
import com.example.demo.JWT.JwtUtil;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService{
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public CustomResponse registerUser(SignUpDTO signUpDTO,boolean isAdmin) {
        Optional<User> existedUser = userRepository.findByEmail(signUpDTO.getEmail());
        if (existedUser.isPresent()){
             new CustomResponse(HttpStatus.CONFLICT.value(), "User already exists", null);
        }
        User newUser = new User();
        newUser.setUsername(signUpDTO.getUsername());
        newUser.setEmail(signUpDTO.getEmail());
        newUser.setPassword(signUpDTO.getPassword());
        newUser.setCreated(new Date());
        String userRole = "user";
        newUser.setRole(userRole);
        userRepository.save(newUser);
        return new CustomResponse(HttpStatus.CREATED.value(), "created",null);
    }

    public CustomResponse userLogin(LoginDTO loginDTO) {
        Optional<User> existedUser = userRepository.findByEmail(loginDTO.getEmail());

        if (existedUser.isEmpty()) {
            return new CustomResponse(HttpStatus.NOT_FOUND.value(), "User not found", null);
        }

        User user = existedUser.get();

        if (!loginDTO.getPassword().equals(user.getPassword())) {
            return new CustomResponse(HttpStatus.BAD_REQUEST.value(), "Incorrect password! Try again", null);
        }

        String token = jwtUtil.generateToken(user.getEmail());
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("user", user);
        responseBody.put("token", token);

        return new CustomResponse(HttpStatus.OK.value(), "Login success", responseBody);
    }

    public CustomResponse getUserById(String userId){
        Optional<User> existedUser = userRepository.findById(userId);
        if (existedUser.isEmpty()){
            new CustomResponse(HttpStatus.NOT_FOUND.value(), "User not found", null);
        }
        return new CustomResponse(HttpStatus.OK.value(), "login success",existedUser);
    }

    public CustomResponse updateUserDetails(String userId,SignUpDTO signUpDTO){
        Optional<User> existedUser = userRepository.findById(userId);
        if (existedUser.isEmpty()){
            new CustomResponse(HttpStatus.NOT_FOUND.value(), "User not found", null);
        }
        User user = existedUser.get();
        if (signUpDTO.getUsername() != null) {
            user.setUsername(signUpDTO.getUsername());
        }
        if (signUpDTO.getEmail() != null) {
            user.setEmail(signUpDTO.getEmail());
        }
        if (signUpDTO.getPassword() != null) {
            user.setPassword(signUpDTO.getPassword()); // Consider hashing passwords before saving!
        }
        userRepository.save(user);
        return new CustomResponse(HttpStatus.OK.value(), "User updated successfully", user);

    }
}
