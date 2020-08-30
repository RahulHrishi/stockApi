package com.stock.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.model.ExpEntity;
 
@Repository
public interface ExpRepository
        extends JpaRepository<ExpEntity, Long> {
 
}
