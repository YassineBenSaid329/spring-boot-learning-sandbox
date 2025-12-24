package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge1_employee_entity;

import jakarta.persistence.*; // You will need imports from here

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}