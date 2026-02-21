package com.product.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        try {
            if (product.getId() == null) {
                product.setCreatedOn(LocalDateTime.now());
            } else {
                product.setModifiedOn(LocalDateTime.now());
            }
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving product");
        } finally {
            System.out.println("ProductServiceImpl.save() executed");
        }
    }

    @Override
    public Product get(Long id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Product> getAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching products");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting product");
        }
    }
}