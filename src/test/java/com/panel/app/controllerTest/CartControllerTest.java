package com.panel.app.controllerTest;

import com.fruits.ecommerce.model.CartDisplayResponse;
import com.fruits.ecommerce.model.CartDisplayResponseCartTotal;
import com.fruits.ecommerce.model.CartDisplayResponseProductsDetailsInner;
import com.panel.app.controller.CartController;
import com.panel.app.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    private Long userId;
    private Long productId;

    @BeforeEach
    public void setUp() {
        userId = 1L;
        productId = 101L;
    }

    @Test
    public void testAddToCard() throws Exception {

        when(cartService.addToCart(userId, productId)).thenReturn("Item added to cart successfully");

        mockMvc.perform(post("/api/v1/cards")
                        .param("userId", userId.toString())
                        .param("productId", productId.toString())
                        .contentType(MediaType.APPLICATION_JSON));

        verify(cartService).addToCart(userId, productId);
    }

    @Test
    public void testGetCart() throws Exception {

        CartDisplayResponse mockResponse = new CartDisplayResponse();

        mockResponse.setCartTotal(new CartDisplayResponseCartTotal());
        List<CartDisplayResponseProductsDetailsInner> cartDisplayResponseProductsDetailsInner=new ArrayList<>();
        mockResponse.setProductsDetails(cartDisplayResponseProductsDetailsInner);

        when(cartService.getCart(userId)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/v1/cards")
                        .param("userId", userId.toString())
                        .contentType(MediaType.APPLICATION_JSON));

        verify(cartService).getCart(userId);
    }
}
