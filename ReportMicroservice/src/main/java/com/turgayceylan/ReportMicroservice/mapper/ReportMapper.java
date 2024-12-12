package com.turgayceylan.ReportMicroservice.mapper;

import com.turgayceylan.ReportMicroservice.dto.core.ReportDTO;
import com.turgayceylan.ReportMicroservice.dto.request.ReportSaveRequest;
import com.turgayceylan.ReportMicroservice.dto.request.ReportUpdateRequest;
import com.turgayceylan.ReportMicroservice.model.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    Report saveRequestToEntity(ReportSaveRequest request);

    ReportDTO entityToDTO(Report report);

    Report updateRequestToEntity(ReportUpdateRequest request);
}
