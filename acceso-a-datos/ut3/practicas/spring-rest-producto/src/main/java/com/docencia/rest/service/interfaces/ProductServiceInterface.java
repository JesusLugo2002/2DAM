package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.model.Product;

public interface ProductServiceInterface {
    Optional<Product> find(Product product);
    Optional<Product> findById(int id);

    List<Product> findAll();

    Product save(Product product);

    boolean delete(Product product);
    boolean deleteById(int id);
}
