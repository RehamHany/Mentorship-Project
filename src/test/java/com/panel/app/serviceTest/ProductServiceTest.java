package com.panel.app.serviceTest;


import com.fruits.ecommerce.model.ProductDTO;
import com.panel.app.entity.Product;
import com.panel.app.repo.ProductRepo;
import com.panel.app.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;


    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        // Create sample ProductDTO and corresponding Product entity
       ProductDTO productDTO = new ProductDTO(1L,"https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");
       Product product = new Product("https//ggghdnhd.nbbvhc","test","per kg",50, "description");

        // Mock repository behavior for save
        when(productRepo.save(any(Product.class))).thenReturn(product);

        // Call the service method
        String result = productService.addProduct(productDTO);

        // Assert the result
        assertNotNull(result);

        // Verify that the repository save was called
        verify(productRepo).save(any(Product.class));
    }


    @Test
    void testGetAllProductsWithPagination() {
        // Create some sample ProductDTO objects
        ProductDTO product1 = new ProductDTO(1L,"https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");
        ProductDTO product2 = new ProductDTO(2L, "https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");

       List<ProductDTO> productList = Arrays.asList(product1, product2);

        Page<ProductDTO> productPage = new PageImpl<>(productList, PageRequest.of(0, 5), 2);

        // Mock repository behavior
        when(productRepo.findAll((Sort) any(Pageable.class))).thenReturn(new ArrayList<>());

        // Call the service method
        List<Product> result = productService.getProducts(0, 5);

        // Assert the result
        assertNotNull(result);
        // Verify that the repository was called once
        verify(productRepo).findAll((Sort) any(Pageable.class));
    }

}
