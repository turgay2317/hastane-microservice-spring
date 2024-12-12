package com.turgayceylan.PatientMicroservice.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class SavePatientRequest {
    private String patientTC;
    private String patientName;
    private String patientSurname;
    private Date patientBirthDate;
}
