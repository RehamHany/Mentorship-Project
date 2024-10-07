package com.ecommerce.GPDemo.repo;

import com.ecommerce.GPDemo.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
    select t from Token t inner join User u on t.user.id = u.id
    where t.user.id = :userId  
    """)
    List<Token> findAllTokensByUser(@Param("userId") Long userId);
    Token findByToken(String token);
}
