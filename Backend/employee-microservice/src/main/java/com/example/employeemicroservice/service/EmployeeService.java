package com.example.employeemicroservice.service;

import com.example.employeemicroservice.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.employeemicroservice.repo.EmployeeRepository;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> list = employeeRepository.findAll();
        if(list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    public ResponseEntity<Employee> getEmployeeInfo(String email){

        Employee emp = employeeRepository.findByEmail(email);
        if(emp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    public ResponseEntity<Boolean> updateEmployeeInfo(String phoneNumber, String email, String currentAddress){
        try{
            Employee employee = employeeRepository.findByEmail(email);
            employee.setAddress(currentAddress);
            employee.setPhoneNumber(phoneNumber);
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.FALSE);
        }

    }
}
