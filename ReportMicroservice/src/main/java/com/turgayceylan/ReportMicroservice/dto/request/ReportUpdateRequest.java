package com.turgayceylan.ReportMicroservice.dto.request;

import lombok.Data;

@Data
public class ReportUpdateRequest {
    private Long reportID;
    private String diagnosisTitle;
    private String diagnosisDetails;
    private byte[] reportImage;
}