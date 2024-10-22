package com.panel.app.service;

import com.fruits.ecommerce.model.CartDisplayResponse;

public interface CartService {
    String addToCart(long userId, long productId);
    CartDisplayResponse getCart(long userId);
}
