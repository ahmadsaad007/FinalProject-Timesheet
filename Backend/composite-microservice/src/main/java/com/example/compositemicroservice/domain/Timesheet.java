package com.example.compositemicroservice.domain;

import java.util.List;
import java.util.Map;

public class Timesheet {

    private String id;
    private String eid;
    private String endDate;
    private Map<String, TimesheetDetail> timesheet;
    private double billingHours;
    private double totalHours;
    private double overtimeHours;
    private String submissionStatus;
    private String approveStatus;
    private String comment;
    private List<String> files;
    private boolean defaultTimesheet;

//    public Timesheet(String id, String eid, String endDate, Map<String, TimeSheetDetail> timeSheetDetails, double billingHours, double totalHours, double overtimeHours, String submissionStatus, String approveStatus, String comment, List<String> files, boolean defaultTimesheet) {
//        this.id = id;
//        this.eid = eid;
//        this.endDate = endDate;
//        this.timeSheetDetails = timeSheetDetails;
//        this.billingHours = billingHours;
//        this.totalHours = totalHours;
//        this.overtimeHours = overtimeHours;
//        this.submissionStatus = submissionStatus;
//        this.approveStatus = approveStatus;
//        this.comment = comment;
//        this.files = files;
//        this.defaultTimesheet = defaultTimesheet;
//    }


    public String getId() {
        return id;
    }

    public String getEid() {
        return eid;
    }

    public String getEndDate() {
        return endDate;
    }

    public Map<String, TimesheetDetail> getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Map<String, TimesheetDetail> timesheet) {
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
