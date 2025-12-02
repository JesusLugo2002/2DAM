package com.docencia.rest.repo.interfaces.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    
}