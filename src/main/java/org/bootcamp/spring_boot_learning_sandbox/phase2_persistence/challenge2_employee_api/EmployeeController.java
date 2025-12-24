package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge2_employee_api;

import org.apache.coyote.Response;
import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        return service.findEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
