package com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
