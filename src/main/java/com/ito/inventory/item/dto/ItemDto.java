package com.ito.inventory.item.dto;

import com.ito.inventory.employee.dto.EmployeeDto;
import com.ito.inventory.location.dto.LocationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemDto {
    private UUID id;
    private String name;
    private String description;
    private String inventoryNumber;
    private Double cost;
    private EmployeeDto materiallyResponsible;
    private String currentState;
    private String boughtAt;
    private String createdAt;
    private LocationDto currentLocation;
}
