package com.example.timesheetmicroservice.service;

import com.example.timesheetmicroservice.domain.TimeSheetDetail;
import com.example.timesheetmicroservice.domain.Timesheet;
import com.example.timesheetmicroservice.repo.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public ResponseEntity<List<Timesheet>> getAllTimesheets(String eid){
        List<Timesheet> list = timesheetRepository.findAllByEid(eid);
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    public ResponseEntity<Timesheet> getSingleTimesheet(String endDate, String eid){
        Timesheet report = timesheetRepository.findByEndDateAndEid(endDate, eid);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }

    public ResponseEntity<Boolean> updateTimesheet(String endDate, String eid, String file, boolean defaultTimesheet, Map<String, TimeSheetDetail> timeSheetDetailMap ){
        try{
            Timesheet timesheet = timesheetRepository.findByEndDateAndEid(endDate, eid);
            timesheet.setTimesheet(timeSheetDetailMap);
            timesheet.setDefaultTimesheet(defaultTimesheet);
            List<String> files =  timesheet.getFiles();
            files.add(file);
            timesheet.setFiles(files);
            timesheet.setSubmissionStatus("complete");
            // missing the part calculating total compensation/billing hours
            timesheetRepository.save(timesheet);
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.FALSE);
        }
    }





}
