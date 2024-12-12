package com.turgayceylan.LaborantMicroservice.controller;

import com.turgayceylan.LaborantMicroservice.dto.core.LaborantDTO;
import com.turgayceylan.LaborantMicroservice.dto.request.LaborantSaveRequest;
import com.turgayceylan.LaborantMicroservice.dto.response.LaborantSaveResponse;
import com.turgayceylan.LaborantMicroservice.service.LaborantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.turgayceylan.LaborantMicroservice.config.RestApis.*;

@RestController
@RequestMapping(LABORANT)
@AllArgsConstructor
public class LaborantController {

    private LaborantService laborantService;

    @PostMapping(SAVE)
    public ResponseEntity<LaborantSaveResponse> saveLaborant(@Valid @RequestBody LaborantSaveRequest request){
        try {
            return new ResponseEntity<>(laborantService.saveLaborant(request), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(GET)
    public ResponseEntity<LaborantDTO> getLaborant(@PathVariable Long id){
        LaborantDTO dto = laborantService.getLaborant(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(SEARCH)
    public ResponseEntity<List<LaborantDTO>> searchLaborant(
            @RequestParam(required = false) String laborantName,
            @RequestParam(required = false) String laborantSurname
    ){
        return new ResponseEntity<>(laborantService.search(laborantName, laborantSurname), HttpStatus.OK);
    }
}
