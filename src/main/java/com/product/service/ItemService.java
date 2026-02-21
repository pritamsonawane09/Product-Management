package com.product.service;

import java.util.List;

import com.product.entity.Item;

public interface ItemService {
	Item save(Item item);

	List<Item> getByProduct(Long productId);
}