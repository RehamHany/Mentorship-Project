package com.ecommerce.GPDemo.controller;

import com.ecommerce.GPDemo.mapper.ProductMapper;
import com.ecommerce.GPDemo.service.ProductService;
import com.fruits.ecommerce.api.ProductApi;
import com.fruits.ecommerce.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class ProductController implements ProductApi {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;


    @Override
    @PostMapping("/products")
    public ResponseEntity<String> _addProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @Override
    @PostMapping("/products")
    public ResponseEntity<List<ProductDTO>> _productsGet(Integer page, Integer size) {
        return ResponseEntity.ok(productMapper.productsToProductDTOs(productService.getProducts(page,size)));
    }


}
