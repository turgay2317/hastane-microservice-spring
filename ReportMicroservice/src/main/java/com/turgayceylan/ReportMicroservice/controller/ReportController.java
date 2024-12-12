package com.turgayceylan.ReportMicroservice.controller;

import com.turgayceylan.ReportMicroservice.dto.core.ReportDTO;
import com.turgayceylan.ReportMicroservice.dto.request.ReportSaveRequest;
import com.turgayceylan.ReportMicroservice.dto.request.ReportUpdateRequest;
import com.turgayceylan.ReportMicroservice.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;

import static com.turgayceylan.ReportMicroservice.config.RestApis.*;

@RequestMapping(REPORT)
@RestController
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> saveReport(@RequestBody ReportSaveRequest request){
        try {
            reportService.saveReport(request);
            return new ResponseEntity<>(true, HttpStatus.CREATED);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(GET)
    public ResponseEntity<ReportDTO> getReport(@PathVariable Long id){
        return new ResponseEntity<>(reportService.getReportById(id),HttpStatus.OK);
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteReport(@PathVariable Long id){
        try {
            reportService.deleteReportById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(PUT)
    public ResponseEntity<Boolean> putReport(@RequestBody ReportUpdateRequest request){
        try {
            reportService.putReport(request);
            return new ResponseEntity<>(true, HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(ORDER)
    public ResponseEntity<List<ReportDTO>> orderReports(@RequestParam(defaultValue = "ASC") String direction){
        return new ResponseEntity<>(reportService.orderReports(direction),HttpStatus.OK);
    }
}
