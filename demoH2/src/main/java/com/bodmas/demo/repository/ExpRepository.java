package com.bodmas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bodmas.demo.model.ExpEntity;
 
@Repository
public interface ExpRepository
        extends JpaRepository<ExpEntity, Long> {
 
}
