package com.example.demo.Controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.SignUpDTO;
import com.example.demo.Model.User;
import com.example.demo.Response.CustomResponse;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    @PreAuthorize("hasRole('USER')")
    public CustomResponse createUser(@RequestBody SignUpDTO signUpDTO){
        return userService.registerUser(signUpDTO,false);
    }

    @PostMapping("/login")
    @PreAuthorize("hasRole('USER')")
    public CustomResponse userLogin(@RequestBody LoginDTO loginDTO){
        return userService.userLogin(loginDTO);
    }

    @GetMapping("/{userId}")
    public CustomResponse getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PutMapping("update/{userId}")
    public CustomResponse updateUser(@PathVariable String userId,@RequestBody SignUpDTO signUpDTO){
        return userService.updateUserDetails(userId,signUpDTO);
    }
}
