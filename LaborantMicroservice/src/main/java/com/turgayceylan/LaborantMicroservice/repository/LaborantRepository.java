package com.turgayceylan.LaborantMicroservice.repository;

import com.turgayceylan.LaborantMicroservice.model.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LaborantRepository extends JpaRepository<Laborant, Long>, JpaSpecificationExecutor<Laborant> {
}
