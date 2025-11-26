package com.docencia.rest.repo.interfaces;

import java.util.Optional;

import com.docencia.rest.model.Product;

public interface ProductDetailRepository {
    Optional<Product> findById(int id);
    Product save(Product product);
    void deleteById(int id);
}
