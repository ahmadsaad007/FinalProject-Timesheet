package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Timesheet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("timesheetmicroservice")
public interface TimesheetClient {

    @GetMapping("/getAllTimesheets/{eid}")
    List<Timesheet> getAllTimesheets(@PathVariable String eid);

    @GetMapping("/getSingleTimesheet")
    Timesheet getSingleTimesheet(@RequestParam(value = "endDate") String endDate,
                                 @RequestParam(value = "eid") String eid);

    @PostMapping("/updateTimesheet")
    Boolean updateTimesheet(
            @RequestParam(value = "obj") List timesheetDetailMap);
}
