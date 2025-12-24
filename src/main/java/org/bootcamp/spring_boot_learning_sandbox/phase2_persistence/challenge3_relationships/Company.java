package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge3_relationships;

import jakarta.persistence.*;
import org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity.Employee;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>() ;

    public Company(){}

    public Company(String name, Set<Employee> employees){
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
