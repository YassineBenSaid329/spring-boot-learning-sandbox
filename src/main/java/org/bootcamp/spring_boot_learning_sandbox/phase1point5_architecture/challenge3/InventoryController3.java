package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phase1.5/inventory3")
public class InventoryController3 {
    private final ServiceInventory3 serviceInventory;

    public InventoryController3(ServiceInventory3 service)
    {
        this.serviceInventory = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id) {
        Item foundItem = serviceInventory.getItemById(id);
        if (foundItem != null) {
            return ResponseEntity.ok(foundItem);
        } else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item createdItem = serviceInventory.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
