package com.ito.inventory.item.entity;

import com.ito.inventory.employee.entity.EmployeeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.redis.core.RedisHash;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @NotBlank
    @NotNull(message = "Name is required")
    private String name; // Наименование
    private String description; // Описание
    @Column(unique = true)
    private String inventoryNumber; // Инвентарник
    private Double cost; // Стоимость
    //@ManyToOne
    //private EmployeeEntity materiallyResponsible; // Метериально ответственный
    private State currentState;
    private String boughtAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date());
}
