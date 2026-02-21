package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Item;
import com.product.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving item");
        } finally {
            System.out.println("ItemServiceImpl.save() executed");
        }
    }

    @Override
    public List<Item> getByProduct(Long productId) {
        try {
            return itemRepository.findByProductId(productId);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching items by product id");
        }
    }
}