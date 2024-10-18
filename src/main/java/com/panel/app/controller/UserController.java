package com.panel.app.controller;


import com.fruits.ecommerce.api.UserApi;
import com.fruits.ecommerce.model.*;
import com.panel.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> _loginUser(@RequestBody Login login) {
        return ResponseEntity.ok(userService.loginUser(login));
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> _register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @Override
    @PostMapping("/registerClient")
    public ResponseEntity<RegisterResponse> _registerClient(CustomerDTO customerDTO) {
        return ResponseEntity.ok(userService.addCustomer(customerDTO));
    }


}
