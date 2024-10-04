package com.ecommerce.GPDemo.service;

import com.ecommerce.GPDemo.entity.Login;
import com.ecommerce.GPDemo.response.AuthenticationResponse;
import com.ecommerce.GPDemo.response.RegisterResponse;
import com.ecommerce.GPDemo.dto.UserDTO;


public interface UserService {
    RegisterResponse addUser(UserDTO user) ;

    AuthenticationResponse loginUser(Login log) ;
}
