package com.panel.app.controllerTest;


import com.fruits.ecommerce.model.AuthenticationResponse;
import com.fruits.ecommerce.model.Login;
import com.fruits.ecommerce.model.RegisterResponse;
import com.fruits.ecommerce.model.UserDTO;
import com.panel.app.controller.UserController;
import com.panel.app.entity.User;
import com.panel.app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(UserController.class)
public class UserControllerTest {

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
