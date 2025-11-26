package com.docencia.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.rest.model.Product;
import com.docencia.rest.repo.jpa.ProductRepository;
import com.docencia.rest.service.interfaces.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(Product product) {
        repository.delete(product);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Product product = new Product(id);
        return delete(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> find(Product product) {
        return findById(product.getId());
    }

    @Override
    public Optional<Product> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
}
