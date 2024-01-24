package com.ito.inventory.item.dto;

import com.ito.inventory.employee.dto.EmployeeDto;
import com.ito.inventory.location.dto.LocationDto;

public class ItemDto {
    private long id;
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
