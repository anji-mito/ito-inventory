package com.ito.inventory.controller;

import com.ito.inventory.item.dto.ItemDto;
import com.ito.inventory.item.entity.ItemEntity;
import com.ito.inventory.item.service.ItemServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpRequest;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    private final ItemServiceImpl itemService;
    private final ModelMapper mapper;
    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable("id")UUID id) {
        return convertToDto(itemService.findItemById(id));
    }
    @PostMapping
    public ItemDto addItem(@Valid @RequestBody ItemDto itemDto) {
        var entity = convertToEntity(itemDto);
        var item = itemService.addItem(entity);
        return convertToDto(item);
    }
    @PutMapping
    public void putItem(@PathVariable("id") UUID id, @Valid @RequestBody ItemDto itemDto) {
        if (!id.equals(itemDto.getId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id does not match");
        var itemEntity = convertToEntity(itemDto);
        itemService.updateItem(id, itemEntity);
    }
    private ItemDto convertToDto(ItemEntity entity) {
        return mapper.map(entity, ItemDto.class);
    }
    private ItemEntity convertToEntity(ItemDto dto) {
        return mapper.map(dto, ItemEntity.class);
    }
}
