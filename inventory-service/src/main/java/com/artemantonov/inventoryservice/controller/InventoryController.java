package com.artemantonov.inventoryservice.controller;

import com.artemantonov.inventoryservice.dto.InventoryResponse;
import com.artemantonov.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("skuCode") List<String> skuCode) {
        return inventoryService.isInStock(skuCode);

    }
}
