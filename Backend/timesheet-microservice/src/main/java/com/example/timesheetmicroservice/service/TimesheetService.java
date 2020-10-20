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

    public ResponseEntity<Boolean> updateTimesheet(List timesheetDetailMap ){
        try{
            String timesheetId = (String) timesheetDetailMap.get(0);
            String eid = (String) timesheetDetailMap.get(1);
            Timesheet timesheet = timesheetRepository.findByIdAndEid(timesheetId, eid);

            timesheet.setBillingHours(Double.parseDouble((String) timesheetDetailMap.get(3)));
            timesheet.setTotalHours(Double.parseDouble((String) timesheetDetailMap.get(4)));
            timesheet.setOvertimeHours(Double.parseDouble((String) timesheetDetailMap.get(5)));
            timesheet.setSubmissionStatus((String) timesheetDetailMap.get(6));
            timesheet.setApproveStatus((String) timesheetDetailMap.get(7));

            List<String> files =  timesheet.getFiles();
            files.add((String) timesheetDetailMap.get(9));
            timesheet.setFiles(files);
            //get the timesheetdetails and set those values
            Map<String, TimeSheetDetail> time = timesheet.getTimesheet();
            for(String key: time.keySet()){
                TimeSheetDetail obj = time.get(key);
                if(obj.getDay().equals("Sunday")){
                    obj.setStartTime((String) timesheetDetailMap.get(13));
                    obj.setEndTime((String) timesheetDetailMap.get(14));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(15)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(16)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(17)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(18)));
                }
                else if(obj.getDay().equals("Monday")){
                    obj.setStartTime((String) timesheetDetailMap.get(21));
                    obj.setEndTime((String) timesheetDetailMap.get(22));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(23)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(24)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(25)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(26)));
                }
                else if(obj.getDay().equals("Tuesday")){
                    obj.setStartTime((String) timesheetDetailMap.get(29));
                    obj.setEndTime((String) timesheetDetailMap.get(30));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(31)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(32)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(33)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(34)));
                }
                else if(obj.getDay().equals("Wednesday")){
                    obj.setStartTime((String) timesheetDetailMap.get(37));
                    obj.setEndTime((String) timesheetDetailMap.get(38));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(39)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(40)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(41)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(42)));
                }
                else if(obj.getDay().equals("Thursday")){
                    obj.setStartTime((String) timesheetDetailMap.get(45));
                    obj.setEndTime((String) timesheetDetailMap.get(46));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(47)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(48)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(49)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(50)));
                }
                else if(obj.getDay().equals("Friday")){
                    obj.setStartTime((String) timesheetDetailMap.get(53));
                    obj.setEndTime((String) timesheetDetailMap.get(54));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(55)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(56)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(57)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(58)));
                }
                else if(obj.getDay().equals("Saturday")){
                    obj.setStartTime((String) timesheetDetailMap.get(61));
                    obj.setEndTime((String) timesheetDetailMap.get(62));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(63)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(64)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(65)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(66)));
                }
            }

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
