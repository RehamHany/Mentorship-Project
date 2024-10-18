package com.panel.app.controllerTest;


import com.fruits.ecommerce.model.ProductDTO;
import com.panel.app.controller.ProductController;
import com.panel.app.entity.Product;
import com.panel.app.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    private ProductDTO productDTO;
    private Product product;

    private List<ProductDTO> productList;

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO(1L,"https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");
        product = new Product("https//ggghdnhd.nbbvhc","test","per kg",50, "description");
    }

    @Test
    void testCreateProductRegisterSuccess() throws Exception {
        when(productService.addProduct(any(ProductDTO.class))).thenReturn("success");

        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON));

        verify(productService).addProduct(any(ProductDTO.class));
    }

    @Test
    public void testGetProductsWithPagination() throws Exception {
        // Create some sample ProductDTO objects
        ProductDTO product1 = new ProductDTO(1L,"https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");
        ProductDTO product2 = new ProductDTO(2L, "https//ggghdnhd.nbbvhc","test","per kg",50.00, "description");

        productList = Arrays.asList(product1, product2);

        Page<ProductDTO> productPage = new PageImpl<>(productList, PageRequest.of(0, 5), 2);

        // Mocking the service method
        Mockito.when(productService.getProducts(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(new ArrayList<>());


        // Perform GET request with pagination params
        mockMvc.perform(get("/api/v1/products")
                        .param("page", "0")
                        .param("size", "5")
                        .contentType(MediaType.APPLICATION_JSON));

    }

}
