package com.example.jobhunter.models;

public class Interns {
    String domain , companyname , location , duration , startdate, stipend, applyby ,jobdesc;

    public Interns(String domain, String companyname, String location, String duration, String startdate, String stipend, String applyby, String jobdesc) {
        this.domain = domain;
        this.companyname = companyname;
        this.location = location;
        this.duration = duration;
        this.startdate = startdate;
        this.stipend = stipend;
        this.applyby = applyby;
        this.jobdesc = jobdesc;
    }

    public Interns() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public String getApplyby() {
        return applyby;
    }

    public void setApplyby(String applyby) {
        this.applyby = applyby;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }
}

