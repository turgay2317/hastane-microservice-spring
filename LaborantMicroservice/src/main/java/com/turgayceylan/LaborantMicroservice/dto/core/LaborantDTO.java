package com.turgayceylan.LaborantMicroservice.dto.core;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LaborantDTO {
    private String laborantName;
    private String laborantSurname;
    private String hospitalID;
}