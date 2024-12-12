package com.turgayceylan.PatientMicroservice.controller;

import com.turgayceylan.PatientMicroservice.dto.core.PatientDTO;
import com.turgayceylan.PatientMicroservice.dto.request.SavePatientRequest;
import com.turgayceylan.PatientMicroservice.dto.response.SavePatientResponse;
import com.turgayceylan.PatientMicroservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import java.util.List;

import static com.turgayceylan.PatientMicroservice.config.RestApis.*;

@RestController
@RequestMapping(PATIENT)
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;

    @PostMapping(SAVE)
    public ResponseEntity<SavePatientResponse> savePatient(@Valid @RequestBody SavePatientRequest dto){
        try {
            SavePatientResponse response = patientService.savePatient(dto);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(GET)
    public ResponseEntity<PatientDTO> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
    }

    @GetMapping(SEARCH)
    public ResponseEntity<List<PatientDTO>> searchPatient(
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) String patientSurname,
            @RequestParam(required = false) String patientTC
    ){
        return new ResponseEntity<>(patientService.search(patientName, patientSurname, patientTC), HttpStatus.OK);
    }
}
