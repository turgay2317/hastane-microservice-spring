package com.turgayceylan.ReportMicroservice.dto.core;
import lombok.*;
import java.util.Date;

@Data
public class PatientDTO {
    private String patientTC;
    private String patientName;
    private String patientSurname;
    private Date patientBirthDate;
}
