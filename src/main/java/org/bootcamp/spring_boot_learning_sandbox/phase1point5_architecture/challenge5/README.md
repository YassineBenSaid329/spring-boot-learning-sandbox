# Challenge 8: Modern Java with `Optional` 🎁

**Topic:** Handling potential `null` values gracefully and writing clean, fluent code.
**Mechanism:** The `java.util.Optional` class.

## 🧐 The Problem: The Dreaded `if/else` Block
Our previous controller code for finding an item worked, but it was "clunky":

```java
// Verbose and procedural
Item foundItem = service.getItemById(id);
if (foundItem != null) {
    ItemDTO dto = ItemDTO.fromEntity(foundItem);
    return ResponseEntity.ok(dto);
} else {
    return ResponseEntity.notFound().build();
}
```
This pattern is prone to errors (`NullPointerException` if you forget a check) and is not very readable.

## 🛠️ The Solution: `Optional`
`Optional` is a "container" object that may or may not contain a non-null value. It forces us to actively handle the "empty" case, making our code safer.

### The `.map()` and `.orElse()` Pattern
The power of `Optional` comes from its fluent methods, which let us chain operations together.

- **`.map(function)`**: If the `Optional` contains a value, it applies the function to that value and returns the result in a new `Optional`. If it's empty, it remains empty.
- **`.orElse(defaultValue)`**: If the `Optional` contains a value, it unwraps and returns it. If it's empty, it returns the `defaultValue` provided.

### 🌊 The New, Fluent Flow

```mermaid
graph TD
    A[Service returns Optional<Item>] --> B{Is Optional empty?};
    B -->|No (Value is present)| C["Apply .map(ItemDTO::fromEntity)"];
    C --> D["Result: Optional<ItemDTO>"];
    D --> E["Apply .map(ResponseEntity::ok)"];
    E --> F["Result: Optional<ResponseEntity<ItemDTO>>"];
    F --> G["Apply .orElse(...) --> Unwraps and returns the ResponseEntity"];

    B -->|Yes| H["Skip all .map() calls"];
    H --> I["Apply .orElse(ResponseEntity.notFound().build())"];
    I --> J["Returns the 'Not Found' ResponseEntity"];
```

## 💻 The Code

### ServiceInventory.java (The Provider)
The service now returns an `Optional` instead of a potentially `null` `Item`.

```java
import java.util.Optional;

@Service
public class ServiceInventory {
    public Optional<Item> getItemById(int id) {
        if (id == 101) {
            // Wrap the result in Optional.of()
            return Optional.of(new Item(101, "mouse", 2));
        } else {
            // Return an empty Optional for "not found"
            return Optional.empty();
        }
    }
}
```

### InventoryController.java (The Consumer)
The controller now uses the fluent chain to handle both success and failure cases in a single, declarative line.

```java
@GetMapping("/{id}")
public ResponseEntity<ItemDTO> getItem(@PathVariable int id) {
    return service.getItemById(id)
            .map(ItemDTO::fromEntity) // If present, convert Item -> ItemDTO
            .map(ResponseEntity::ok)    // If present, wrap DTO in a 200 OK
            .orElse(ResponseEntity.notFound().build()); // If empty, build a 404
}
```
---
**Key Takeaway:** `Optional` transforms null-checking from a procedural `if/else` block into a declarative, functional pipeline.