package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge5;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceInventory {
    public Optional<Item> getItemById(int id) {
        if(id == 101){
            return Optional.of(new Item(101, "mouse",2));
        }
        else
            return Optional.empty();
    }

    public Item createItem(Item item) {
        return item;
    }

}
