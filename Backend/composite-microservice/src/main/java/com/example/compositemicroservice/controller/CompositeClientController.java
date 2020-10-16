package com.example.compositemicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@RestController
public class CompositeClientController {

    @GetMapping("/getEmployeeInfo")
    public String getEmployeeInfo() throws RestClientException, IOException{
        String baseUrl = "";

        return baseUrl;
    }

}
