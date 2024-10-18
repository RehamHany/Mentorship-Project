package com.panel.app.service;


import com.fruits.ecommerce.model.*;
import com.panel.app.entity.*;
import com.panel.app.mapper.CustomerMapper;
import com.panel.app.mapper.UserMapper;
import com.panel.app.repo.CustomerRepo;
import com.panel.app.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;




    @Override
    public RegisterResponse addUser(UserDTO user)  {

        UserRole userRole=new UserRole(Role.VISITOR);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);

        User user1= UserMapper.INSTANCE.toEntity(user);
        user1.setUserRoleList(userRoles);

        User savedUser=userRepo.save(user1);


        return new RegisterResponse("success",savedUser.getEmail());

    }

    @Override
    public RegisterResponse addCustomer(CustomerDTO customerDTO) {
        UserRole userRole=new UserRole(Role.CLIENT);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);

        User user= new User(customerDTO.getUsername(), customerDTO.getEmail(), customerDTO.getPassword()) ;
        user.setUserRoleList(userRoles);

        Customer customer= CustomerMapper.INSTANCE.toEntity(customerDTO);
        user.setCustomer(customer);
        User savedUser=userRepo.save(user);

        customer.setUser(user);
        customer.setCardInfo(modelMapper.map(customerDTO.getCreditDTO(),CreditCard.class));
        customer.setBillingAddress(modelMapper.map(customerDTO.getBillAddDTO(),BillAddress.class));
        customer.setShippingAddress(modelMapper.map(customerDTO.getShipAddDTO(),ShipAddress.class));
        Customer savedCustom=customerRepo.save(customer);


        return new RegisterResponse("success",savedCustom.getEmail());
    }


    @Override
    public AuthenticationResponse loginUser(Login login) {

        User user = userRepo.findByEmail(login.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));

        Map<String , Object> extraClaims = new HashMap<>();
        String jwtToken = jwtService.createToken(user , extraClaims);

        return new AuthenticationResponse("success",user.getEmail());
    }



}
