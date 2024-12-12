package com.turgayceylan.ReportMicroservice.dto.request;


import lombok.Data;
import java.util.Date;

@Data
public class ReportSaveRequest {
    private String fileNumber;
    private Long patientID;
    private Long laborantID;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private Date reportDate;
    private byte[] reportImage;
}
