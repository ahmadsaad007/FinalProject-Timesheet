package com.example.timesheetbackend.repo;

import com.example.timesheetbackend.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findAll();

    Employee findByEmail(String email);
}
