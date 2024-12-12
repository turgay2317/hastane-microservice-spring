package com.turgayceylan.LaborantMicroservice.service;

import com.turgayceylan.LaborantMicroservice.dto.core.LaborantDTO;
import com.turgayceylan.LaborantMicroservice.dto.request.LaborantSaveRequest;
import com.turgayceylan.LaborantMicroservice.dto.response.LaborantSaveResponse;
import com.turgayceylan.LaborantMicroservice.mapper.LaborantMapper;
import com.turgayceylan.LaborantMicroservice.model.Laborant;
import com.turgayceylan.LaborantMicroservice.repository.LaborantRepository;
import com.turgayceylan.LaborantMicroservice.specifications.LaborantSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LaborantService {

    private LaborantRepository repository;
    private LaborantMapper mapper;

    public LaborantSaveResponse saveLaborant(LaborantSaveRequest request) {
        Laborant savedLaborant = repository.save(mapper.requestToEntity(request));
        return mapper.entityToResponse(savedLaborant);
    }

    public LaborantDTO getLaborant(Long id){
        Laborant laborant = repository.findById(id).get();
        return mapper.entityToDTO(laborant);
    }

    public List<LaborantDTO> search(String laborantName, String laborantSurname){
        Specification<Laborant> spec = Specification
                .where(LaborantSpecifications.hasFirstName(laborantName))
                .and(LaborantSpecifications.hasLastName(laborantSurname));

        List<Laborant> laborants = repository.findAll(spec);
        return laborants.stream().map(patient -> mapper.entityToDTO(patient)).collect(Collectors.toList());
    }
}
