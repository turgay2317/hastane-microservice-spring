package com.turgayceylan.ReportMicroservice.service.client;

import com.turgayceylan.ReportMicroservice.dto.core.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.turgayceylan.ReportMicroservice.config.RestApis.GET_PATIENT;

@FeignClient(name = "patient-service", url = "http://localhost:9091")
public interface PatientClient {
    @GetMapping(GET_PATIENT)
    PatientDTO getPatientDetails(@PathVariable Long id);
}
