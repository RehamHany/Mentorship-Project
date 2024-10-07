package com.ecommerce.GPDemo.serviceTest;


import com.ecommerce.GPDemo.entity.User;
import com.ecommerce.GPDemo.entity.Login;
import com.ecommerce.GPDemo.repo.UserRepo;
import com.ecommerce.GPDemo.response.AuthenticationResponse;
import com.ecommerce.GPDemo.response.RegisterResponse;
import com.ecommerce.GPDemo.service.UserService;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fruits.ecommerce.model.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;



import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterSuccess() {
        UserDTO userDto = new UserDTO("test","test@example.com", "password");
        User user = new User("test","test@example.com", "encodedPassword");

        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(new User());
        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        RegisterResponse registeredUser = authService.addUser(userDto);

        assertNotNull(registeredUser);
        assertEquals("test@example.com", registeredUser.getEmail());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testLoginSuccess() {
        String email = "test@example.com";
        String password = "password";
        User user = new User("test",email, "encodedPassword");

        when(userRepository.findByEmail(email)).thenReturn(new User());
        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);
        Login login1=new Login(email, password);
        AuthenticationResponse loggedInUser = authService.loginUser(login1);

        assertNotNull(loggedInUser);
        assertEquals(email, loggedInUser.getEmail());
        verify(userRepository).findByEmail(email);
    }


}
