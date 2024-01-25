package com.ito.inventory.item.service;

import com.ito.inventory.item.entity.ItemEntity;
import com.ito.inventory.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    public Iterable<ItemEntity> findAllItems() {
        return itemRepository.findAll();
    }
    public ItemEntity findItemById(UUID id) {
        return findById(id);
    }
    public void removeItemById(UUID id) {
        itemRepository.deleteById(id);
    }
    public ItemEntity addItem(ItemEntity item) {
        return itemRepository.save(item);
    }
    public void updateItem(UUID id, ItemEntity item) {
        itemRepository.save(item);
    }
}
