package com.turgayceylan.ReportMicroservice.repository;

import com.turgayceylan.ReportMicroservice.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
