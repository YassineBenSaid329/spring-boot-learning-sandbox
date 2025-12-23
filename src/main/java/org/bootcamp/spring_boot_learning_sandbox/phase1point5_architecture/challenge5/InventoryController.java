package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge5;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    private final ServiceInventory sevice;

    public InventoryController(ServiceInventory sevice) {
        this.sevice = sevice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable int id)
    {
        return sevice.getItemById(id)
                .map(ItemDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody Item item)
    {
        Item createdItem = sevice.createItem(item);
        ItemDTO dto = ItemDTO.fromEntity(createdItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
