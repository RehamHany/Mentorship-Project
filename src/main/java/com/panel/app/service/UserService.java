package com.panel.app.service;


import com.fruits.ecommerce.model.*;
import com.panel.app.entity.User;

public interface UserService {
    RegisterResponse addUser(UserDTO user) ;

    RegisterResponse addCustomer(CustomerDTO customerDTO) ;
    AuthenticationResponse loginUser(Login login);
}
