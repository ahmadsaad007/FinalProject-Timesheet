package com.example.timesheetmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TimesheetMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetMicroserviceApplication.class, args);
    }

}
