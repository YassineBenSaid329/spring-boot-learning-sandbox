package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge2_employee_api;

import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Optional<Employee> findEmployeeById(long id) {
        return repo.findById(id);
    }
}
