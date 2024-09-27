package com.ecommerce.GPDemo.controller;

import com.ecommerce.GPDemo.entity.login;
import com.ecommerce.GPDemo.service.UserService;
import com.ecommerce.GPDemo.Response.AuthenticationResponse;
import com.ecommerce.GPDemo.dto.UserDTO;
import com.ecommerce.GPDemo.Response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponse addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PostMapping("/login")
    public AuthenticationResponse loginUser(@RequestBody login log, @RequestParam Map<String , Object> claims)  {
        return userService.loginUser(log);
    }
}
