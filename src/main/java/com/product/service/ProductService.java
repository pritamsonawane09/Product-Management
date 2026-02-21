package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {
	Product save(Product product);

	Product get(Long id);

	List<Product> getAll();

	void delete(Long id);
}