package com.stock.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.model.Stocks;
 
@Repository
public interface StockRepository
        extends JpaRepository<Stocks, Long> {
 
}

