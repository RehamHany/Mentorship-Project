package com.ecommerce.GPDemo.service;

import com.ecommerce.GPDemo.entity.Product;
import com.fruits.ecommerce.model.ProductDTO;

import java.util.List;

public interface ProductService {

    String addProduct(ProductDTO productDTO);

    List<Product> getProducts(int min,int max);
}
