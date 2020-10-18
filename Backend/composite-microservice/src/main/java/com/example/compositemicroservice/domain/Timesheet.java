package com.example.compositemicroservice.domain;

import java.util.List;
import java.util.Map;

public class Timesheet {
    private String id;
    private String eid;
    private String endDate;
    private Map<String, TimesheetDetails> timesheet;
    private double billingHours;
    private double totalHours;
    private double overtimeHours;
    private String submissionStatus;
    private String approveStatus;
    private String comment;
    private List<String> files;
    private boolean defaultTimesheet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Map<String, TimesheetDetails> getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Map<String, TimesheetDetails> timesheet) {
        this.timesheet = timesheet;
    }

    public double getBillingHours() {
        return billingHours;
    }

    public void setBillingHours(double billingHours) {
        this.billingHours = billingHours;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public boolean isDefaultTimesheet() {
        return defaultTimesheet;
    }

    public void setDefaultTimesheet(boolean defaultTimesheet) {
        this.defaultTimesheet = defaultTimesheet;
    }
}
