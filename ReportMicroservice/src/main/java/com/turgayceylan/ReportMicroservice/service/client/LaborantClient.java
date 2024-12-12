package com.turgayceylan.ReportMicroservice.service.client;


import com.turgayceylan.ReportMicroservice.dto.core.LaborantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.turgayceylan.ReportMicroservice.config.RestApis.GET_LABORANT;


@FeignClient(name = "laborant-service", url = "http://localhost:9090")
public interface LaborantClient {
    @GetMapping(GET_LABORANT)
    LaborantDTO getLaborantDetails(@PathVariable Long id);
}
