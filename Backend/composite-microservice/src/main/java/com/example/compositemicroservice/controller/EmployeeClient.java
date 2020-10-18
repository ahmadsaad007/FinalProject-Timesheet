package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("employeemicroservice")
public interface EmployeeClient {

    @GetMapping("/getAllEmployee")
    List<Employee> getAllEmployees();
}
