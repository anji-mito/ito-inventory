package com.ito.inventory.item.repository;

import com.ito.inventory.item.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<ItemEntity, UUID> {
}
