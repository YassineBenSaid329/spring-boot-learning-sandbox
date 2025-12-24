package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge2_employee_api;

import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Employee> findByDepartment(String department) {
        return repo.findByDepartment(department);
    }

    public List<Employee> findByIdGreaterThan(Long id) {
        return repo.findByIdGreaterThan(id);
    }

    public List<Employee> findByLastNameContaining(String infix){
        return repo.findByLastNameContaining(infix);
    }

    public List<Employee> findByDeptAndLastName(String dept, String infix){
        return repo.findByDepartmentAndLastNameContaining(dept,infix);
    }
}
