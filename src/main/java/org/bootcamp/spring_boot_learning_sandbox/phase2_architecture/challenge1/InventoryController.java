package org.bootcamp.spring_boot_learning_sandbox.phase2_architecture.challenge1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phase2/inventory")
public class InventoryController {

    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id) {
        return new Item(id, "Demo Item", 100);
    }

    @GetMapping
    public List<Item> getItems() {
        return List.of(
                new Item(101, "Mechanical Keyboard", 50),
                new Item(102, "Wireless Mouse", 20),
                new Item(103, "Curved Monitor", 5)
        );
    }
}
