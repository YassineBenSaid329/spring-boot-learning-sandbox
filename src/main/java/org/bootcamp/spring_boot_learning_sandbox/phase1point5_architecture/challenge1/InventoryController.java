package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phase2/inventory")
public class InventoryController {

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id) {
        if (id==101) {
            Item foundItem = new Item(101, "Mechanical Keyboard", 50);
            return ResponseEntity.ok(foundItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Item> getItems() {
        return List.of(
                new Item(101, "Mechanical Keyboard", 50),
                new Item(102, "Wireless Mouse", 20),
                new Item(103, "Curved Monitor", 5)
        );
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        System.out.println("Received item: " + item.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
