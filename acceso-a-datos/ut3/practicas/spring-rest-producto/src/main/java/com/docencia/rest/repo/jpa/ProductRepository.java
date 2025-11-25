package com.docencia.rest.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}