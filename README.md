# Spring Boot Learning Sandbox ☕️🚀

> **A "No-Magic" approach to mastering Spring Boot.**

This repository documents my personal journey from Spring Boot basics to advanced architectural patterns. Unlike standard tutorials, this sandbox focuses on understanding the *internals*—moving beyond simple copy-pasting to deep comprehension of the "How" and "Why."

## 🗺️ The Mastery Roadmap

I am building this project in distinct **Phases**, each isolating a specific layer of the Spring ecosystem.

```mermaid
graph TD
    Start((Start)) --> P1[Phase 1: Web Inputs & Data Binding]
    P1 --> P2[Phase 2: Data Persistence & JPA]
    P2 --> P3[Phase 3: Architecture & DTOs]
    P3 --> P4[Phase 4: Security & Advanced Topics]
    
    style P1 fill:#a8e6cf,stroke:#333,stroke-width:2px,color:black
    style P2 fill:#ff8b94,stroke:#333,stroke-width:2px,stroke-dasharray: 5 5
    style P3 fill:#dcedc1,stroke:#333,stroke-width:2px,stroke-dasharray: 5 5
    style P4 fill:#dcedc1,stroke:#333,stroke-width:2px,stroke-dasharray: 5 5
```

## 📚 Progress Log

### ✅ Phase 1: Web Inputs & Data Binding
*Status: Completed*
Focuses on the Controller layer and how Spring maps HTTP requests to Java objects.
*   **Challenge 1:** Query Parameters (`@RequestParam`)
*   **Challenge 2:** Path Variables (`@PathVariable`)
*   **Challenge 3:** JSON Payloads & Jackson (`@RequestBody`)

### 🚧 Phase 2: Data Persistence (Coming Soon)
*Status: Planned*
Focuses on JPA, Hibernate internals, Entity lifecycles, and Relationship ownership.

---

## 🛠️ Technology Stack
*   **Java 17** (LTS)
*   **Spring Boot 3**
*   **Maven**
*   **Spring Web** (MVC, REST)
*   **Jackson** (JSON Processing)

## 🚀 How to Run
1.  Clone the repository.
2.  Open in IntelliJ IDEA or Eclipse.
3.  Run `SpringBootLearningSandboxApplication.java`.
4.  Use **Postman** to test the endpoints documented in each phase.

---
*Created by [Mohamed Yassine Ben Said]*
