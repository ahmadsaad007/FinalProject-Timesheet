package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CompositeClientController {

    private EmployeeClient employeeClient;

    public CompositeClientController(EmployeeClient employeeClient) {
        super();
        this.employeeClient = employeeClient;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list = this.employeeClient.getAllEmployees();
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

}
