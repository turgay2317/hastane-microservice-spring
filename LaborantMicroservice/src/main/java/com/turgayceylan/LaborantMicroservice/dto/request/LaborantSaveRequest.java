package com.turgayceylan.LaborantMicroservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LaborantSaveRequest {
    private String laborantName;
    private String laborantSurname;
    private String hospitalID;
}
