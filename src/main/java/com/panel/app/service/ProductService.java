package com.panel.app.service;


import com.fruits.ecommerce.model.ProductDTO;
import com.panel.app.entity.Product;

import java.util.List;

public interface ProductService {

    String addProduct(ProductDTO productDTO);

    List<Product> getProducts(int pageNumber, int pageSize);
}
