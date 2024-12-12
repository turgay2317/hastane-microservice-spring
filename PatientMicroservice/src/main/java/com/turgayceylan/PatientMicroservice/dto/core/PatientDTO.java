package com.turgayceylan.PatientMicroservice.dto.core;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private Long patientID;
    private String patientTC;
    private String patientName;
    private String patientSurname;
    private Date patientBirthDate;
}
