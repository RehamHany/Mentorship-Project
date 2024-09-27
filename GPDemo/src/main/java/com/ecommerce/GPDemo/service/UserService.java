package com.ecommerce.GPDemo.service;

import com.ecommerce.GPDemo.Response.AuthenticationResponse;
import com.ecommerce.GPDemo.Response.RegisterResponse;
import com.ecommerce.GPDemo.dto.UserDTO;
import com.ecommerce.GPDemo.entity.login;

public interface UserService {
    RegisterResponse addUser(UserDTO user) ;

    AuthenticationResponse loginUser(login log) ;
}
