package com.ecommerce.GPDemo.controller;

import com.ecommerce.GPDemo.entity.Login;
import com.ecommerce.GPDemo.service.UserService;

import com.fruits.ecommerce.api.UserApi;
import com.fruits.ecommerce.model.AuthenticationResponse;
import com.fruits.ecommerce.model.RegisterResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController implements UserApi{
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> _loginUser(@RequestBody com.fruits.ecommerce.model.Login login) {
        return ResponseEntity.ok(modelMapper.map(userService.loginUser(modelMapper.map(login, Login.class)), AuthenticationResponse.class));
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> _registerUser(@RequestBody com.fruits.ecommerce.model.UserDTO userDTO) {
        return ResponseEntity.ok(modelMapper.map(userService.addUser(userDTO), RegisterResponse.class));
    }
}
