package org.bootcamp.spring_boot_learning_sandbox.phase2_architecture.challenge3;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    private final ServiceInventory serviceInventory;

    public InventoryController(ServiceInventory service)
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
