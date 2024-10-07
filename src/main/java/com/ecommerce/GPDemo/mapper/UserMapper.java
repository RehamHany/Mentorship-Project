package com.ecommerce.GPDemo.mapper;

import com.fruits.ecommerce.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.ecommerce.GPDemo.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
