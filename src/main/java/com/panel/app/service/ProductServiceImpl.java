package com.panel.app.service;


import com.fruits.ecommerce.model.ProductDTO;
import com.panel.app.entity.Product;
import com.panel.app.mapper.ProductMapper;
import com.panel.app.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public String addProduct(ProductDTO productDTO) {
        productRepo.save(ProductMapper.INSTANCE.toEntity(productDTO));
        return "product created successfully";
    }

    @Override
    public List<Product> getProducts(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        return productRepo.findAll((Sort) pageable);
    }
}
