package com.ecommerce.GPDemo.service;

import com.ecommerce.GPDemo.Response.AuthenticationResponse;
import com.ecommerce.GPDemo.Response.RegisterResponse;
import com.ecommerce.GPDemo.dto.UserDTO;
import com.ecommerce.GPDemo.entity.*;
import com.ecommerce.GPDemo.repo.TokenRepository;
import com.ecommerce.GPDemo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllTokenByUser(User user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return ;
        }

        validTokens.forEach(t-> {
            t.setExpired(true);
            t.setRevoked(true);
            tokenRepository.deleteById(t.getId());
        });

        tokenRepository.saveAll(validTokens);
    }
    @Override
    public RegisterResponse addUser(UserDTO user) {

        user.setRole(Role.VISITOR);
        User savedUser=userRepo.save(modelMapper.map(user,User.class));

        return new RegisterResponse("Registered Successfully :)", savedUser.getEmail());
    }

    @Override
    public AuthenticationResponse loginUser(login log) {

        User user = userRepo.findByEmail(log.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(log.getEmail(),log.getPassword()));

        Map<String , Object> extraClaims = new HashMap<>();
        String jwtToken = jwtService.createToken(user , extraClaims);
        revokeAllTokenByUser(user);
        saveUserToken(user, jwtToken);


        return new AuthenticationResponse("Login Success", user.getEmail(), jwtToken);

    }
}
