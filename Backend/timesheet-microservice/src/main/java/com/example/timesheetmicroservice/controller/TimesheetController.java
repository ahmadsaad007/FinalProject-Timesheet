package com.example.timesheetmicroservice.controller;

import com.example.timesheetmicroservice.domain.TimeSheetDetail;
import com.example.timesheetmicroservice.domain.Timesheet;
import com.example.timesheetmicroservice.service.TimesheetService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/getAllTimesheets/{eid}")
    public ResponseEntity<List<Timesheet>> getAllTimesheets(@PathVariable String eid ) {
        return timesheetService.getAllTimesheets(eid);
    }

    @GetMapping("/getSingleTimesheet")
    public ResponseEntity<Timesheet> getSingleTimesheet(@RequestParam(value = "endDate") String endDate,
                                                        @RequestParam(value = "eid") String eid){
        return timesheetService.getSingleTimesheet(endDate,eid);
    }

    @PostMapping("/updateTimesheet")
    public ResponseEntity<Boolean> updateTimesheet(@RequestParam(value = "obj") List<Object> timesheetDetailMap) throws IOException {
       //System.out.println(timesheetDetailMap.toString());

       return timesheetService.updateTimesheet(timesheetDetailMap);
        // json object convertor
        //Map<String, TimeSheetDetail> timeSheetDetail = new ObjectMapper().readValue((JsonParser) timesheetDetailMap, new TypeReference<Map<String, TimeSheetDetail>>() {});

        //return timesheetService.updateTimesheet(endDate,eid,file,defaultTimesheet,timeSheetDetail);

    }
}
