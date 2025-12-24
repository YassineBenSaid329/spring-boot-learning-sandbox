package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String departement);
    List<Employee> findByLastNameContaining(String infix);
    List<Employee> findByIdGreaterThan(Long startingId);
    List<Employee> findByDepartmentAndLastNameContaining(String department, String infix);
}