package com.turgayceylan.PatientMicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;

    @Column(nullable = false, unique = true, columnDefinition = "CHAR(11)")
    @Pattern(regexp = "^[0-9]{11}$", message = "TC Kimlik Numarası 11 haneli olmalıdır")
    private String patientTC;

    private String patientName;
    private String patientSurname;
    private Date patientBirthDate;
}
