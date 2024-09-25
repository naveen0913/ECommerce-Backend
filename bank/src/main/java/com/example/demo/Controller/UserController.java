package com.example.demo.Controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.SignUpDTO;
import com.example.demo.Model.User;
import com.example.demo.Response.CustomResponse;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("user/signup")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> createUser(@RequestBody SignUpDTO signUpDTO){
//        return userService.registerUser(signUpDTO,false);
//    }

//    @PostMapping("user/login")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO){
//        return userService.userLogin(loginDTO);
//    }

}
