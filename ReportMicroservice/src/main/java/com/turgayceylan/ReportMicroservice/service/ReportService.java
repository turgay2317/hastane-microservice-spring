package com.turgayceylan.ReportMicroservice.service;

import com.turgayceylan.ReportMicroservice.dto.core.LaborantDTO;
import com.turgayceylan.ReportMicroservice.dto.core.PatientDTO;
import com.turgayceylan.ReportMicroservice.dto.core.ReportDTO;
import com.turgayceylan.ReportMicroservice.dto.request.ReportSaveRequest;
import com.turgayceylan.ReportMicroservice.dto.request.ReportUpdateRequest;
import com.turgayceylan.ReportMicroservice.mapper.ReportMapper;
import com.turgayceylan.ReportMicroservice.model.Report;
import com.turgayceylan.ReportMicroservice.repository.ReportRepository;
import com.turgayceylan.ReportMicroservice.service.client.LaborantClient;
import com.turgayceylan.ReportMicroservice.service.client.PatientClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {
    private ReportRepository repository;
    private ReportMapper mapper;
    private PatientClient patientClient;
    private LaborantClient laborantClient;
    public void saveReport(ReportSaveRequest request) {
        Report report = mapper.saveRequestToEntity(request);
        repository.save(report);
    }

    public ReportDTO getReportById(Long id) {
        Report report = repository.findById(id).get();
        ReportDTO dto = mapper.entityToDTO(report);
        PatientDTO patientDTO = patientClient.getPatientDetails(report.getPatientID());
        LaborantDTO laborantDTO = laborantClient.getLaborantDetails(report.getLaborantID());
        dto.setPatient(patientDTO);
        dto.setLaborant(laborantDTO);
        return dto;
    }

    public void deleteReportById(Long id) {
        repository.deleteById(id);
    }

    public void putReport(ReportUpdateRequest request) {
        Report currentReport = repository.findById(request.getReportID()).get();
        currentReport.setDiagnosisTitle(request.getDiagnosisTitle());
        currentReport.setDiagnosisDetails(request.getDiagnosisDetails());
        currentReport.setReportImage(request.getReportImage());
        repository.save(currentReport);
    }

    public List<ReportDTO> orderReports(String direction) {
        Sort sort = direction.equalsIgnoreCase("DESC")
                ? Sort.by("reportDate").descending()
                : Sort.by("reportDate").ascending();
        return repository.findAll(sort).stream().map(report -> mapper.entityToDTO(report)).collect(Collectors.toList());
    }
}
