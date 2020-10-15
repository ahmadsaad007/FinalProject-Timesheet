package com.example.timesheetbackend.repo;

import com.example.timesheetbackend.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    Employee findFirstByFirstName(String firstName);
}
