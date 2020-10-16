package com.example.timesheetbackend.controller;

import com.example.timesheetbackend.domain.Employee;
import com.example.timesheetbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping("/getEmployeeInfo")
    public ResponseEntity<Employee> getEmployeeInfo(@RequestParam(value = "email") String email){
        return employeeService.getEmployeeInfo(email);
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<Boolean> updateEmployeeInfo(@RequestParam(value = "phone") String phoneNumber,
                                                      @RequestParam(value = "email") String email,
                                                      @RequestParam(value = "address") String address){
        return employeeService.updateEmployeeInfo(phoneNumber, email, address);
    }
}
