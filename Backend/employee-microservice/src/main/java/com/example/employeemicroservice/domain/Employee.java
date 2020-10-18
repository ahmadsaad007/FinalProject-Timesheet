package com.example.employeemicroservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String eid;
    private String defaultTimesheetId;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

    private String emergencyContactNumber;
    private String emergencyContactName;

    private int floating;

    public Employee(String id, String firstName, String lastName, String address, String email, String phoneNumber,
                    String emergencyContactNumber, String emergencyContactName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emergencyContactNumber = emergencyContactNumber;
        this.emergencyContactName = emergencyContactName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDefaultTimesheetId() {
        return defaultTimesheetId;
    }

    public void setDefaultTimesheetId(String defaultTimesheetId) {
        this.defaultTimesheetId = defaultTimesheetId;
    }

    public int getFloating() {
        return floating;
    }

    public void setFloating(int floating) {
        this.floating = floating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", emergencyContactName='" + emergencyContactName + '\'' +
                '}';
    }
}
