package com.panel.app.service;

import com.fruits.ecommerce.model.*;
import com.panel.app.entity.Cart;
import com.panel.app.entity.CartItem;
import com.panel.app.entity.Product;
import com.panel.app.entity.User;
import com.panel.app.repo.CartRepo;
import com.panel.app.repo.ProductRepo;
import com.panel.app.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepo cartRepo;



    @Override
    public String addToCart(long userId, long productId) {

        Optional<User> userOptional = userRepo.findById(userId);
        if (!userOptional.isPresent()) {
            return "User not found";
        }
        User user = userOptional.get();

        Optional<Product> productOptional = productRepo.findById(productId);
        if (!productOptional.isPresent()) {
            return "Product not found";
        }
        Product product = productOptional.get();

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart(user);
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        product.setCart(cartItem);
        cartItem.setQuantity(product.getCart().getQuantity()+1);
        List<CartItem> cartItemList=new ArrayList<>();
        cartItemList.add(cartItem);
        cart.setUser(user);
        user.setCart(cart);
        cartItem.setCart(cart);
        cart.setCartItems(cartItemList);

        cartRepo.save(cart);

        return "success";
    }

    @Override
    public CartDisplayResponse getCart(long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (!userOptional.isPresent()) {
            return null;
        }
        User user = userOptional.get();
        long subT=0;
        List<CartDisplayResponseProductsDetailsInner> productDS=new ArrayList<>();
        List<CartItem> cartItemList=user.getCart().getCartItems();

        for (CartItem cartItem:cartItemList){
            CartDisplayResponseProductsDetailsInner productD = getCartDisplayResponseProductsDetailsInner(cartItem);

            subT+=(long) (cartItem.getQuantity()*cartItem.getProduct().getPrice());
            productDS.add(productD);
        }
        CartDisplayResponseCartTotal cartT=new CartDisplayResponseCartTotal();
        cartT.setSubTotal(subT);
        cartT.setShipCost(user.getCart().getShippingCost());
        cartT.setTotal(user.getCart().getShippingCost()+subT);

        CartDisplayResponse cartDisplayResponse=new CartDisplayResponse();
        cartDisplayResponse.setCartTotal(cartT);
        cartDisplayResponse.setProductsDetails(productDS);
        return cartDisplayResponse;
    }

    private static CartDisplayResponseProductsDetailsInner getCartDisplayResponseProductsDetailsInner(CartItem cartItem) {
        CartDisplayResponseProductsDetailsInner productD=new CartDisplayResponseProductsDetailsInner();
        productD.setId(cartItem.getProduct().getId());
        productD.setImage(cartItem.getProduct().getImage());
        productD.setName(cartItem.getProduct().getName());
        productD.setPrice(cartItem.getProduct().getPrice());
        productD.setQuantity(cartItem.getQuantity());
        productD.setTotal((long) (cartItem.getQuantity()* cartItem.getProduct().getPrice()));
        return productD;
    }
}
