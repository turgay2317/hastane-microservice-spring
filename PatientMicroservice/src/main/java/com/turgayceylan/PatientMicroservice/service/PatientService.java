package com.turgayceylan.PatientMicroservice.service;

import com.turgayceylan.PatientMicroservice.dto.core.PatientDTO;
import com.turgayceylan.PatientMicroservice.dto.request.SavePatientRequest;
import com.turgayceylan.PatientMicroservice.dto.response.SavePatientResponse;
import com.turgayceylan.PatientMicroservice.mapper.PatientMapper;
import com.turgayceylan.PatientMicroservice.model.Patient;
import com.turgayceylan.PatientMicroservice.repository.PatientRepository;
import com.turgayceylan.PatientMicroservice.specifications.PatientSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository repository;
    private PatientMapper mapper;

    public SavePatientResponse savePatient(SavePatientRequest request){
        Patient savedPatient = repository.save(mapper.requestToEntity(request));
        return mapper.entityToResponse(savedPatient);
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = repository.findById(id).get();
        return mapper.entityToDTO(patient);
    }

    public List<PatientDTO> search(String patientName, String patientSurname, String patientTC){
        Specification<Patient> spec = Specification
                .where(PatientSpecifications.hasFirstName(patientName))
                .and(PatientSpecifications.hasLastName(patientSurname))
                .and(PatientSpecifications.hasTC(patientTC));
        List<Patient> patients = repository.findAll(spec);
        return patients.stream().map(patient -> mapper.entityToDTO(patient)).collect(Collectors.toList());
    }
}
