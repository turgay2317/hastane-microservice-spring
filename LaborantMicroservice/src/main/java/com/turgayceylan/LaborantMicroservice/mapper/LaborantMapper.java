package com.turgayceylan.LaborantMicroservice.mapper;

import com.turgayceylan.LaborantMicroservice.dto.core.LaborantDTO;
import com.turgayceylan.LaborantMicroservice.dto.request.LaborantSaveRequest;
import com.turgayceylan.LaborantMicroservice.dto.response.LaborantSaveResponse;
import com.turgayceylan.LaborantMicroservice.model.Laborant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborantMapper {
    Laborant requestToEntity(LaborantSaveRequest request);
    LaborantSaveResponse entityToResponse(Laborant laborant);
    LaborantDTO entityToDTO(Laborant laborant);
}
