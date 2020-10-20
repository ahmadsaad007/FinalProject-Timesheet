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
            System.out.println(timesheetDetailMap.toString());

            String eid = (String) timesheetDetailMap.get(0);
            String endDate = (String) timesheetDetailMap.get(1);
            Timesheet timesheet = timesheetRepository.findByEidAndEndDate(eid,endDate);

            //timesheet.setBillingHours(Double.parseDouble((String) timesheetDetailMap.get(2)));
            timesheet.setTotalHours(Double.parseDouble((String) timesheetDetailMap.get(3)));
            timesheet.setOvertimeHours(Double.parseDouble((String) timesheetDetailMap.get(4)));
            double hours = 0.0;

            String file = (String) timesheetDetailMap.get(8);
            if(!file.equals("none") || file != null || file.length()!=0){
                timesheet.setFiles(file);
                timesheet.setSubmissionStatus("Completed");
            }
            else{
                timesheet.setSubmissionStatus("Incomplete");
            }

            //get the timesheetdetails and set those values
            Map<String, TimeSheetDetail> time = timesheet.getTimesheet();
            for(String key: time.keySet()){
                TimeSheetDetail obj = time.get(key);
                if(obj.getDay().equals("Sunday")){
                    obj.setStartTime((String) timesheetDetailMap.get(12));
                    obj.setEndTime((String) timesheetDetailMap.get(13));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(14)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(15)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(16)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(17)));
                }
                else if(obj.getDay().equals("Monday")){
                    obj.setStartTime((String) timesheetDetailMap.get(20));
                    obj.setEndTime((String) timesheetDetailMap.get(22));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(22)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(23)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(24)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(25)));
                }
                else if(obj.getDay().equals("Tuesday")){
                    obj.setStartTime((String) timesheetDetailMap.get(28));
                    obj.setEndTime((String) timesheetDetailMap.get(29));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(30)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(31)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(32)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(33)));
                }
                else if(obj.getDay().equals("Wednesday")){
                    obj.setStartTime((String) timesheetDetailMap.get(36));
                    obj.setEndTime((String) timesheetDetailMap.get(37));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(38)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(39)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(40)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(41)));
                }
                else if(obj.getDay().equals("Thursday")){
                    obj.setStartTime((String) timesheetDetailMap.get(44));
                    obj.setEndTime((String) timesheetDetailMap.get(45));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(46)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(47)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(48)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(49)));
                }
                else if(obj.getDay().equals("Friday")){
                    obj.setStartTime((String) timesheetDetailMap.get(52));
                    obj.setEndTime((String) timesheetDetailMap.get(53));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(54)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(55)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(56)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(57)));
                }
                else if(obj.getDay().equals("Saturday")){
                    obj.setStartTime((String) timesheetDetailMap.get(60));
                    obj.setEndTime((String) timesheetDetailMap.get(61));
                    obj.setHours(Double.parseDouble((String)timesheetDetailMap.get(62)));
                    obj.setFloating(Boolean.parseBoolean((String)timesheetDetailMap.get(63)));
                    obj.setHoliday(Boolean.parseBoolean((String)timesheetDetailMap.get(64)));
                    obj.setVacation(Boolean.parseBoolean((String)timesheetDetailMap.get(65)));
                }
                hours += obj.getHours();
            }

            //calculate total hours
            timesheet.setBillingHours(hours);
            timesheetRepository.save(timesheet);

            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.FALSE);
        }
    }





}
