package com.example.compositemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompositeMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompositeMicroserviceApplication.class, args);
    }

}
