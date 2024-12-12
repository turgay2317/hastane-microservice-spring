package com.turgayceylan.LaborantMicroservice.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LaborantSaveResponse {
    private Long laborantID;
    private String laborantName;
    private String laborantSurname;
    private String hospitalID;
}
