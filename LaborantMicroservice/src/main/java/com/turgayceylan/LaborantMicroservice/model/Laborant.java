package com.turgayceylan.LaborantMicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Laborant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laborantID;
    private String laborantName;
    private String laborantSurname;

    @Pattern(regexp = "^[0-9]{7}$", message = "Hastane Kimlik Numarası 7 haneli olmalıdır")
    @Column(nullable = false, unique = true, columnDefinition = "CHAR(7)")
    private String hospitalID;

}
