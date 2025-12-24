package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phase1.5/inventory4")
public class InventoryController4 {
    private final ServiceInventory4 service;

    public InventoryController4(ServiceInventory4 service)
    {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable int id)
    {
        Item itemFound = service.getItemById(id);
        if (itemFound != null){
            ItemDTO dto = ItemDTO.fromEntity(itemFound);
            return ResponseEntity.ok(dto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody Item item){
        Item createdItem = service.createItem(item);
        ItemDTO dto = ItemDTO.fromEntity(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }
}
