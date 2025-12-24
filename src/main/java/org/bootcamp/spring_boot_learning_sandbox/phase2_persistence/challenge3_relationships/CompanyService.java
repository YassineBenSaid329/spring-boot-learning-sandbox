package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge3_relationships;

import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repo;

    public CompanyService(CompanyRepository repo){
        this.repo= repo;
    }

    public Company createCompany(Company company) {
        return repo.save(company);
    }

    public Employee addEmployeeToCompany(Long companyId, Employee employee)
    {
        Company company = repo.findById(companyId)
                        .orElseThrow(() -> new RuntimeException("Company not found!"));

        employee.setCompany(company);
        company.getEmployees().add(employee);

        repo.save(company);

        return company.getEmployees().stream()
                .filter(e -> e.equals(employee))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(("Could not find saved employee")));
    }

    public Optional<Company> findCompanieById(Long id){
        return repo.findById(id);
    }



}
