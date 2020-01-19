package com.example.jobhunter.models;

public class GovtJobs {
    String jobname , companyname , location , vacancies , applyby, agelimit, qualifications, jobdescription ;

    public GovtJobs(String jobname, String companyname, String location, String vacancies, String applyby, String agelimit, String qualifications, String jobdescription) {
        this.jobname = jobname;
        this.companyname = companyname;
        this.location = location;
        this.vacancies = vacancies;
        this.applyby = applyby;
        this.agelimit = agelimit;
        this.qualifications = qualifications;
        this.jobdescription = jobdescription;
    }

    public GovtJobs() {

    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
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

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public String getApplyby() {
        return applyby;
    }

    public void setApplyby(String applyby) {
        this.applyby = applyby;
    }

    public String getAge() {
        return agelimit;
    }

    public void setAge(String agelimit) {
        this.agelimit = agelimit;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }
}

