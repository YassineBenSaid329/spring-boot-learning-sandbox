package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge3_relationships;

import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company createdCompany = service.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @PostMapping("/{companyId}/employees")
    public ResponseEntity<Employee> addEmployee(
            @PathVariable Long companyId,
            @RequestBody Employee employee
    ){
        try{
            return ResponseEntity.ok(service.addEmployeeToCompany(companyId,employee));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        return service.findCompanieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
