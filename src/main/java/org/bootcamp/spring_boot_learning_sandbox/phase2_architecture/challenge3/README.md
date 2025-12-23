# Challenge 6: The Service Layer & Dependency Injection 🧠

**Topic:** Separating business logic from the Controller.
**Mechanism:** The `@Service` annotation and Dependency Injection (DI).

## 🧐 The Problem: "Fat Controllers"
In our previous challenges, the `InventoryController` contained business logic:
```java
// Logic inside the Controller (Bad Practice!)
if (id == 101) { 
    // ... return an item
}
```
This violates the **Single Responsibility Principle**.
*   **A Controller's Job:** Handle HTTP requests and responses. It's the "Waiter".
*   **A Service's Job:** Execute business rules and coordinate data. It's the "Chef".

Mixing these makes the code hard to test, hard to reuse, and hard to maintain.

## 🛠️ The Solution: The Service Layer
We move all the business logic into a dedicated `Service` class. The Controller becomes "thin" and simply **delegates** the work to the service.

### ⚙️ Under the Hood: Dependency Injection (The Core of Spring)
How does the Controller get an instance of the Service? We don't write `new ServiceInventory()`. Spring does it for us using **Dependency Injection**.

1.  **`@Service` - The Component Scan:** We annotate `ServiceInventory` with `@Service`. On startup, Spring scans our project, finds this annotation, and creates a single, managed instance of this class (called a **Bean**). It stores this bean in its "Application Context" (a container of all beans).

2.  **Constructor Injection - The Wiring:** We tell the `InventoryController` that it **requires** a `ServiceInventory` to function by adding it to the constructor.

```mermaid
graph TD
    subgraph Spring Application Context (The Container)
        A[ServiceInventory Bean]
    end

    subgraph Startup Process
        B(Spring creates Beans) -->|Finds @Service| A
        B -->|Finds @RestController| C{Create InventoryController}
        C -->|"Needs ServiceInventory in constructor"| D{Request Bean from Context}
        A -->|Provides Bean| D
        D --> E[Controller is created & wired]
    end
```

> **Why Constructor Injection is Best:** It makes dependencies explicit and required. The `InventoryController` cannot even be created without a valid `ServiceInventory`, which prevents `NullPointerExceptions` and makes the code safer.

## 💻 The Code

### ServiceInventory.java (The "Chef")
This class now holds all the logic.

```java
@Service
public class ServiceInventory {
    public Item getItemById(int id) {
        if(id == 101){
            return new Item(101, "mouse", 2);
        } else {
            return null; // We'll improve this later with Optionals
        }
    }
    // ... other business methods
}
```

### InventoryController.java (The "Waiter")
The controller is now clean. It just delegates.

```java
@RestController
public class InventoryController {
    // A private, final field to hold the dependency
    private final ServiceInventory serviceInventory;

    // The dependency is "injected" via the constructor
    public InventoryController(ServiceInventory service) {
        this.serviceInventory = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id) {
        // Delegate the work to the service
        Item foundItem = serviceInventory.getItemById(id);
        
        // Handle the HTTP response
        if (foundItem != null) {
            return ResponseEntity.ok(foundItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```

---
**Key Takeaway:** Controllers handle HTTP. Services handle Logic. Dependency Injection connects them.