package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CompositeClientController {


    private EmployeeClient employeeClient;

    private TimesheetClient timesheetClient;

    public CompositeClientController(EmployeeClient employeeClient) {
        super();
        this.employeeClient = employeeClient;
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
}
