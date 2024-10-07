package com.ecommerce.GPDemo.controllerTest;

import com.ecommerce.GPDemo.controller.UserController;
import com.ecommerce.GPDemo.dto.UserDTO;
import com.ecommerce.GPDemo.entity.Login;
import com.ecommerce.GPDemo.entity.User;

import com.ecommerce.GPDemo.response.AuthenticationResponse;
import com.ecommerce.GPDemo.response.RegisterResponse;
import com.ecommerce.GPDemo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(UserController.class)
public class userController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService authService;


    private UserDTO userDto;
    private User user;

    @BeforeEach
    void setUp() {
        userDto = new UserDTO("test","test@example.com", "password");
        user = new User("test","test@example.com", "encodedPassword");
    }


    @Test
    void testRegisterSuccess() throws Exception {
        when(authService.addUser(any(UserDTO.class))).thenReturn(new RegisterResponse());

        mockMvc.perform(post("/api/v1/user/register")
                        .contentType(MediaType.APPLICATION_JSON));

        verify(authService).addUser(any(UserDTO.class));
    }

    @Test
    void testLoginSuccess() throws Exception {
        Login login1=new Login(anyString(), anyString());
        when(authService.loginUser(login1)).thenReturn(new AuthenticationResponse());

        mockMvc.perform(post("/api/v1/user/login")
                .contentType(MediaType.APPLICATION_JSON));

        verify(authService).loginUser(login1);
    }
}
