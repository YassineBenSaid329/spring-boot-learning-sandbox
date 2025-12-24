# Application Configuration (`application.properties`) ⚙️

## What is this file?
This file is the primary way to configure our Spring Boot application's behavior without changing any Java code. Spring Boot provides thousands of "properties" that we can set here to control everything from the server port to database logging.

---

##  H2 Database Configuration
This block configures the embedded H2 database for a better development experience.

```properties
# Enable the web-based database console
spring.h2.console.enabled=true
# Set the URL path for accessing the console
spring.h2.console.path=/h2-console
```
*   **Why we use it:** The H2 Console is a simple but powerful tool that allows us to connect directly to our running in-memory database. We can use it to view the tables Hibernate creates, inspect data, and even run raw SQL queries for debugging.

---

## JPA & Hibernate Configuration
This block configures how Spring Data JPA and its underlying engine, Hibernate, interact with the database.

```properties
# Automatically create/update database tables based on our @Entity classes
spring.jpa.hibernate.ddl-auto=update

# Show the actual SQL queries in the console
spring.jpa.show-sql=true

# Make the logged SQL pretty and readable
spring.jpa.properties.hibernate.format_sql=true
```
*   **`ddl-auto=update`**: This is the "magic" that reads our `@Entity` classes and generates the `CREATE TABLE` or `ALTER TABLE` SQL statements. It's incredibly useful for development but should be used with caution in production.
*   **`show-sql=true`**: This is our **"No-Magic"** window. It prints every single SQL query that Hibernate runs to the console. This is the single most important property for learning, as it lets us see *exactly* what our Java code is doing to the database.
*   **`format_sql=true`**: Makes the output from `show-sql` neatly formatted and indented, which is much easier to read.


