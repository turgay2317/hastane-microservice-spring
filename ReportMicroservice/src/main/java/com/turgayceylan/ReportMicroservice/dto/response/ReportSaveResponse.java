package com.turgayceylan.ReportMicroservice.dto.response;

import lombok.Data;
import java.util.Date;

@Data
public class ReportSaveResponse {
    private String fileNumber;
    private String patientName;
    private String patientSurname;
    private String patientTC;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private byte[] reportImage;
}
