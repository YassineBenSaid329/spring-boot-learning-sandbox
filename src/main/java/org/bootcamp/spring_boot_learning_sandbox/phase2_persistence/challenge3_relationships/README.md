# Challenge 6: Entity Relationships (@OneToMany) 🔗

**Topic:** Modeling real-world connections between data tables.
**Mechanisms:** JPA Relationship Annotations (`@OneToMany`, `@ManyToOne`, `cascade`, `fetch`).

This challenge moves beyond single, isolated tables and builds a connected system where a `Company` can have many `Employee`s.

## 🧐 The Problem: The Infinite Loop & The "N+1" Query
When modeling relationships,s two major problems arise:
1.  **Infinite JSON Recursion:** If `Company` has a list of `Employee`s and `Employee` has a `Company`, how do we stop Jackson from getting stuck in a loop during serialization?
2.  **Performance:** When we load a `Company`, should we also load all 1,000 of its employees immediately? Doing so is slow and inefficient (this is the famous "N+1 Select Problem").

## 🛠️ The Solution: A Well-Defined Relationship
We solve these problems by carefully configuring our relationship with specific attributes.

### 1. The Annotations: `@OneToMany` and `@ManyToOne`
We need to tell Hibernate about the connection from both sides.

*   **`@ManyToOne` (in `Employee`):** This is the **"Owning Side"**. It's responsible for the actual `company_id` foreign key column in the database.
*   **`@OneToMany` (in `Company`):** This is the **"Inverse Side"**. It doesn't create any columns. The `mappedBy="company"` attribute tells Hibernate: "To figure out this list, look for the `company` field in the `Employee` entity."

### 2. The Attributes: `cascade` and `fetch` (The Critical Details)
These two attributes control the behavior and performance of the relationship.

| Attribute | Question it Answers | Our Choice | Why? |
| :--- | :--- | :--- | :--- |
| **`cascade`** | If I save/delete the Parent, what happens to the Children? | `CascadeType.ALL` | **The "Domino Effect."** For convenience, so saving a `Company` also saves any new `Employee`s in its list. |
| **`fetch`** | When I load the Parent, should I load the Children too? | `FetchType.LAZY` | **Performance.** To avoid loading thousands of employees unnecessarily. The employees are only fetched from the DB when `company.getEmployees()` is called. |

### 3. The Quick Fix: `@JsonIgnore`
To solve the infinite loop, we add `@JsonIgnore` to the "weaker" side of the relationship (`Employee` -> `Company`). This tells Jackson to stop serializing at that point, breaking the loop.

> **Note:** A more robust, long-term solution is the **DTO Pattern**, which gives us full control over the API's public shape.

## 💻 The Code

### Company.java (The "One" Side)
```java
@Entity
public class Company {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
    // ... constructors, getters, setters ...
}
```

### Employee.java (The "Many" Side)
```java
@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    // ... other fields ...

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id") // Defines the foreign key column
    private Company company;
    
    // Break the infinite loop for JSON serialization
    @JsonIgnore
    public Company getCompany() {
        return company;
    }
    // ... constructors, getters, setters ...
}
```

### CompanyService.java (The Logic)
The logic to link the entities together must happen on both sides before saving.
```java
public Employee addEmployeeToCompany(Long companyId, Employee employee) {
    // 1. Find the parent
    Company company = companyRepository.findById(companyId)
            .orElseThrow(() -> new RuntimeException("Company not found!"));
    
    // 2. Link child to parent
    employee.setCompany(company);
    // 3. Link parent to child
    company.getEmployees().add(employee);
    
    // 4. Save the parent (cascading will save the new employee)
    companyRepository.save(company);
    
    return employee;
}
```
---
**Key Takeaway:** Relationships require careful configuration of the **owning side**, **cascading behavior**, and **fetching strategy** to ensure correctness and performance.