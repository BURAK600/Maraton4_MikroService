package com.burak.repository;

import com.burak.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findOptinalByProductName(String productName);

    Optional<Product> findOptinalById(Long id);
}
