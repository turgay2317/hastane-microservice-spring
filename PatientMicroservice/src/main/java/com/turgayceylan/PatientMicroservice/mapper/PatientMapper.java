package com.turgayceylan.PatientMicroservice.mapper;

import com.turgayceylan.PatientMicroservice.dto.core.PatientDTO;
import com.turgayceylan.PatientMicroservice.dto.request.SavePatientRequest;
import com.turgayceylan.PatientMicroservice.dto.response.SavePatientResponse;
import com.turgayceylan.PatientMicroservice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    SavePatientResponse entityToResponse(Patient patient);
    Patient requestToEntity(SavePatientRequest request);
    PatientDTO entityToDTO(Patient patient);

}
