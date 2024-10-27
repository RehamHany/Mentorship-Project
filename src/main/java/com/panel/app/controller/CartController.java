package com.panel.app.controller;

import com.fruits.ecommerce.api.CardApi;
import com.fruits.ecommerce.model.CartDisplayResponse;
import com.panel.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class CartController implements CardApi {

    @Autowired
    private CartService cartService;

    @Override
    @PostMapping("/carts")
    public ResponseEntity<String> _addToCard(Long userId, Long productId) {
        return ResponseEntity.ok(cartService.addToCart(userId,productId));
    }

    @Override
    @GetMapping("/carts")
    public ResponseEntity<CartDisplayResponse> _cardsGet(Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }
}
