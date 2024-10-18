package com.panel.app.repo;


import com.panel.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> findOneByEmailAndPassword(String email, String password);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);



}
