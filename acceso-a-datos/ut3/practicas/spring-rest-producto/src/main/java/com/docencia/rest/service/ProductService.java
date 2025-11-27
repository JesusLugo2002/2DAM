package com.docencia.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.rest.model.ProductEntity;
import com.docencia.rest.repo.interfaces.ProductDetailRepository;
import com.docencia.rest.repo.interfaces.jpa.ProductRepository;
import com.docencia.rest.service.interfaces.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    private ProductDetailRepository detailRepository;

    @Autowired
    public void setDetailRepository(ProductDetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    public boolean delete(ProductEntity product) {
        productRepository.delete(product);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        ProductEntity product = new ProductEntity(id);
        return delete(product);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> find(ProductEntity product) {
        return findById(product.getId());
    }

    @Override
    public Optional<ProductEntity> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }
}
