package com.burak.repository;

import com.burak.repository.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {

    Stock findByProductId(Long productId);

    Optional<Stock> findOptionalByProductId(Long productId);
}
