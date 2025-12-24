# POM & Dependencies (`pom.xml`) 📦

## What is this file?
The `pom.xml` (Project Object Model) is the central configuration file for **Maven**, our project's build tool. It tells Maven everything it needs to know to build, package, and manage this application.

**Its primary jobs are:**
1.  **Dependency Management:** Listing all the external libraries (JARs) our project needs.
2.  **Build Configuration:** Defining how to compile our Java code and package it into a runnable `.jar` file.
3.  **Project Metadata:** Containing information like the project's name, version, and Java version.

---

## 🏛️ Core Dependencies

### `spring-boot-starter-parent`
This isn't a dependency, but our `<parent>` tag. It's the "Bill of Materials" (BOM) that ensures all our other Spring dependencies use compatible versions, preventing conflicts.

### `spring-boot-starter-web`
*   **Purpose:** Provides all the essentials for building web applications, including RESTful APIs.
*   **Key Libraries Included:**
    *   **Spring MVC:** The core framework for handling HTTP requests with Controllers.
    *   **Jackson:** The library for automatically converting Java Objects to/from JSON.
    *   **Embedded Tomcat:** A built-in web server, so we don't need to deploy our app to an external server.

### `spring-boot-starter-data-jpa`
*   **Purpose:** The "brain" for database interaction. It simplifies data access by providing a powerful abstraction over raw SQL.
*   **Key Libraries Included:**
    *   **Spring Data JPA:** Provides the `JpaRepository` interface, which magically generates database queries for us.
    *   **Hibernate:** The most popular JPA implementation. It's the engine that translates our Java `@Entity` objects into SQL commands.
    *   **HikariCP:** A high-performance database connection pool.

---

## 💾 Database Dependencies

### `h2database`
*   **Purpose:** Provides a lightweight, in-memory SQL database.
*   **Why we use it:** It's perfect for development and learning. It requires zero setup, starts instantly with our application, and is wiped clean on every restart, providing a fresh slate for testing. The `<scope>runtime</scope>` tag means it's only needed when the application runs, not during compilation.

---

## ✨ Developer Experience Dependencies

### `spring-boot-devtools`
*   **Purpose:** Massively speeds up development by automating tedious tasks.
*   **Key Features:**
    *   **Automatic Restart:** Detects code changes and automatically restarts the application server, much faster than a manual restart.
    *   **LiveReload:** Can be configured to automatically refresh the browser when resources change.
    *   **Property Defaults:** Sensible caching defaults for development.
    *   **`<optional>true</optional>`:** This ensures that if another project uses our sandbox as a library, it won't inherit DevTools, as it's not meant for production.