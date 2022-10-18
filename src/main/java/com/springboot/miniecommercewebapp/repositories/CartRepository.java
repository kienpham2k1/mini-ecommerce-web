package com.springboot.miniecommercewebapp.repositories;


import com.springboot.miniecommercewebapp.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(String userId);
    Optional<Cart> findByUserIdAndProductId(String userId, int productId);
}