package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge2_employee_api;

import org.apache.coyote.Response;
import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeeByDepartment(@RequestParam String depatment) {
        List<Employee> employees = service.findByDepartment(depatment);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/search/lastname")
    public ResponseEntity<List<Employee>> searchByLastName(@RequestParam String contains){
        List<Employee> employees = service.findByLastNameContaining(contains);
        return ResponseEntity.ok(employees);
    }

    // Endpoint for "GreaterThan"
    @GetMapping("/search/id-greater-than")
    public ResponseEntity<List<Employee>> searchByIdGreaterThan(@RequestParam Long id) {
        return ResponseEntity.ok(service.findByIdGreaterThan(id));
    }

    // Endpoint for the logical "And" combination
    @GetMapping("/search/dept-and-lastname")
    public ResponseEntity<List<Employee>> searchByDeptAndLastName(
            @RequestParam String dept,
            @RequestParam String contains
    ) {
        return ResponseEntity.ok(service.findByDeptAndLastName(dept, contains));
    }

}
