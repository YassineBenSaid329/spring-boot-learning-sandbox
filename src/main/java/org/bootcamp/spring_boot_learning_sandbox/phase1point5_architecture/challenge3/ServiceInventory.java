package org.bootcamp.spring_boot_learning_sandbox.phase1point5_architecture.challenge3;

import org.springframework.stereotype.Service;

@Service
public class ServiceInventory {
    public Item getItemById(int id) {
        if(id == 101){
            return new Item(101, "mouse",2);
        }
        else
            return null;
    }

    public Item createItem(Item item) {
        return item;
    }

}
