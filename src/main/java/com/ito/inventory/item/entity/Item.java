package com.ito.inventory.item.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @NotNull(message = "Name is required")
    private String name; // Наименование
    private String description; // Описание
    private String inventoryNumber; // Инвентарник
    private Float cost; // Стоимость
    private String materiallyResponsible; // Метериально ответственный
    private State currentState;
    private String currentLocation;
    private String boughtAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
}
