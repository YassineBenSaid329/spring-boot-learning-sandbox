package org.bootcamp.spring_boot_learning_sandbox.phase2_architecture.challenge4;

public class ItemDTO {
    private int id;
    private String name;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ItemDTO fromEntity(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        if (item.getQuantity() > 10) {
            dto.setStatus("Instock");
        } else if (item.getQuantity() > 0) {
            dto.setStatus("Low Stock");
        } else {
            dto.setStatus("Out of stock");
        }
        return dto;
    }
}
