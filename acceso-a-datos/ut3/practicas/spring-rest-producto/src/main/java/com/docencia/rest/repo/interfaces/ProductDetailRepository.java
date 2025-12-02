package com.docencia.rest.repo.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docencia.rest.model.ProductDetailDocument;

public interface ProductDetailRepository extends MongoRepository<ProductDetailDocument, Integer> {
    // Optional<ProductDetailDocument> findById(int id);
    // ProductDetailDocument save(int productId, ProductDetailDocument detail);
    // void deleteById(int id);
}
