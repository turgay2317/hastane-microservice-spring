package com.turgayceylan.PatientMicroservice.dto.response;

import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavePatientResponse {
    private Long patientID;
    private String patientTC;
    private String patientName;
    private String patientSurname;
    private Date patientBirthDate;
}