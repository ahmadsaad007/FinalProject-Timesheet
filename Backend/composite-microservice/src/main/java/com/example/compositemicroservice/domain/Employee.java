package com.example.compositemicroservice.domain;

public class Employee {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
