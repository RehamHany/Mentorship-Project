package com.panel.app.serviceTest;

import com.panel.app.entity.Cart;
import com.panel.app.entity.CartItem;
import com.panel.app.entity.Product;
import com.panel.app.entity.User;
import com.panel.app.repo.CartRepo;
import com.panel.app.repo.ProductRepo;
import com.panel.app.repo.UserRepo;
import com.panel.app.service.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Optional;
import com.fruits.ecommerce.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private ProductRepo productRepo;

    @Mock
    private CartRepo cartRepo;

    @InjectMocks
    private CartServiceImpl cartService;

    private User user;
    private Product product;
    private Cart cart;
    private CartItem cartItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


        user = new User();
        user.setId(1L);


        product = new Product();
        product.setId(101L);
        product.setPrice(50.0);


        cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);

        // Set up mock cart
        cart = new Cart();
        cart.setUser(user);
        cart.setCartItems(new ArrayList<>());
        cart.getCartItems().add(cartItem);
        cart.setShippingCost(45L);

        user.setCart(cart);
    }


    @Test
    public void testAddToCart_Success() {

        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        when(productRepo.findById(101L)).thenReturn(Optional.of(product));

        String result = cartService.addToCart(1L, 101L);

        verify(cartRepo).save(any(Cart.class));

        assertEquals("success", result);
    }

    @Test
    public void testAddToCart_UserNotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.empty());

        String result = cartService.addToCart(1L, 101L);

        assertEquals("User not found", result);
        verify(cartRepo, never()).save(any(Cart.class)); // Ensure save was not called
    }

    @Test
    public void testAddToCart_ProductNotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        when(productRepo.findById(101L)).thenReturn(Optional.empty());

        String result = cartService.addToCart(1L, 101L);

        assertEquals("Product not found", result);
        verify(cartRepo, never()).save(any(Cart.class)); // Ensure save was not called
    }


    @Test
    public void testGetCart_Success() {

        when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        CartDisplayResponse response = cartService.getCart(1L);

        assertNotNull(response);
    }

    @Test
    public void testGetCart_UserNotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.empty());

        CartDisplayResponse response = cartService.getCart(1L);

        assertNull(response);
    }

}
