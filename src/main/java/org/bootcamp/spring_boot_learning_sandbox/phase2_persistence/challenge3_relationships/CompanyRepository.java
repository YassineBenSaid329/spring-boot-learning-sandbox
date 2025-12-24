package org.bootcamp.spring_boot_learning_sandbox.phase2_persistence.challenge3_relationships;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
