package com.example.compositemicroservice.controller;

import com.example.compositemicroservice.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("employeemicroservice")
public interface EmployeeClient {

    @GetMapping("/getAllEmployees")
    List<Employee> getAllEmployees();

    @GetMapping("/getEmployeeInfo")
    Employee getEmployeeInfo(@RequestParam(value = "email") String email);

    @PostMapping("/updateInfo")
    Boolean updateEmployeeInfo(@RequestParam(value = "phone") String phoneNumber,
                                                      @RequestParam(value = "email") String email,
                                                      @RequestParam(value = "address") String address);
}
