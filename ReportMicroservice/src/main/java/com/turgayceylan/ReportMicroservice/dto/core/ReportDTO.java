package com.turgayceylan.ReportMicroservice.dto.core;

import lombok.Data;
import java.util.Date;

@Data
public class ReportDTO {
    private Long reportID;
    private String fileNumber;
    private PatientDTO patient;
    private LaborantDTO laborant;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private byte[] reportImage;
}
