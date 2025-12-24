package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 1. Tells Spring: "This is a Data Access Bean"
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // 2. What Entity class does this repository manage?
    // 3. What is the data type of the Primary Key of that Entity?

    // THAT'S IT! LEAVE THIS INTERFACE EMPTY.
    // Spring Data JPA will create the methods for us.
}