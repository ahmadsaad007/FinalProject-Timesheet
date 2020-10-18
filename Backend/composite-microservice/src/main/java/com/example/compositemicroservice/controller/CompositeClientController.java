package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Employee;
import com.example.compositemicroservice.domain.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CompositeClientController {

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private TimesheetClient timesheetClient;



    public CompositeClientController(EmployeeClient employeeClient, TimesheetClient timesheetClient) {
        super();
        this.employeeClient = employeeClient;
        this.timesheetClient  = timesheetClient;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list = this.employeeClient.getAllEmployees();
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/getEmployeeInfo")
    public ResponseEntity<Employee> getEmployeeInfo(@RequestParam(value = "email") String email){
        Employee employee = this.employeeClient.getEmployeeInfo(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<Boolean> updateEmployeeInfo(@RequestParam(value = "phone") String phoneNumber,
                                                      @RequestParam(value = "email") String email,
                                                      @RequestParam(value = "address") String address){
        Boolean b = this.employeeClient.updateEmployeeInfo(phoneNumber, email, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

//    now we need to add the mappings for TimeSheet
    @GetMapping("/getAllTimesheets")
    public ResponseEntity<List<Timesheet>> getAllTimesheets(@RequestParam(value = "email") String email){
        Employee employee = this.employeeClient.getEmployeeInfo(email);
        List<Timesheet> timesheets = this.timesheetClient.getAllTimesheets(employee.getEid());
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheets);
    }

    @GetMapping("/getSingleTimesheet")
    public ResponseEntity<Timesheet> getSingleTimesheet(@RequestParam(value = "endDate") String endDate,
                                                        @RequestParam(value = "email") String email){
        Employee employee = this.employeeClient.getEmployeeInfo(email);
        Timesheet timesheet = this.timesheetClient.getSingleTimesheet(endDate, employee.getEid());
        return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
    }

    @GetMapping("/updateTimesheet")
    public ResponseEntity<Boolean> updateTimesheet(@RequestParam(value = "endDate") String endDate,
                                                   @RequestParam(value = "email") String email,
                                                   @RequestParam(value = "file") String file,
                                                   @RequestParam(value = "defaultTimesheet") boolean defaultTimesheet,
                                                   @RequestParam(value = "obj") Object timesheetDetailMap) throws IOException {
        Employee employee = this.employeeClient.getEmployeeInfo(email);
        Boolean success = this.timesheetClient.updateTimesheet(endDate, employee.getEid(), file, defaultTimesheet, timesheetDetailMap);
        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }




}
