package com.ecommerce.GPDemo.controller;

import com.ecommerce.GPDemo.entity.Login;
import com.ecommerce.GPDemo.service.UserService;
import com.ecommerce.GPDemo.response.AuthenticationResponse;

import com.ecommerce.GPDemo.dto.UserDTO;
import com.ecommerce.GPDemo.response.RegisterResponse;
import com.fruits.ecommerce.api.UserApi;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController implements UserApi{
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

//    @PostMapping("/register")
//    public RegisterResponse addUser(@RequestBody UserDTO userDTO){
//        return userService.addUser(userDTO);
//    }
//
//    @PostMapping("/login")
//    public AuthenticationResponse loginUser(@RequestBody Login log, @RequestParam Map<String , Object> claims)  {
//        return userService.loginUser(log);
//    }


    @Override
    @PostMapping("/login")
    public ResponseEntity<com.fruits.ecommerce.model.AuthenticationResponse> _loginUser(@RequestBody com.fruits.ecommerce.model.Login login) {
        return ResponseEntity.ok(modelMapper.map(userService.loginUser(modelMapper.map(login, Login.class)), com.fruits.ecommerce.model.AuthenticationResponse.class));
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<com.fruits.ecommerce.model.RegisterResponse> _registerUser(@RequestBody com.fruits.ecommerce.model.UserDTO userDTO) {
        return ResponseEntity.ok(modelMapper.map(userService.addUser(modelMapper.map(userDTO, UserDTO.class)), com.fruits.ecommerce.model.RegisterResponse.class));
    }
}
