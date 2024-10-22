package com.panel.app.mapper;



import com.fruits.ecommerce.model.ProductDTO;
import com.panel.app.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOs(List<Product> products);
}
