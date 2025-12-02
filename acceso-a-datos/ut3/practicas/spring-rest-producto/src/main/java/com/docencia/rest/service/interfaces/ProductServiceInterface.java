package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.model.ProductEntity;

public interface ProductServiceInterface {
    Optional<ProductEntity> find(ProductEntity product);
    Optional<ProductEntity> findById(int id);

    List<ProductEntity> findAll();

    ProductEntity save(ProductEntity product);

    boolean delete(ProductEntity product);
    boolean deleteById(int id);
}
