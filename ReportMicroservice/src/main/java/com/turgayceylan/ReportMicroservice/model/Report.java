package com.turgayceylan.ReportMicroservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;

    private String fileNumber;

    private Long patientID;

    private Long laborantID;

    private String diagnosisTitle;

    private String diagnosisDetails;

    private Date reportDate;

    @Lob
    @Column(nullable = false)
    private byte[] reportImage;
}
