package com.example.jobhunter.models;

public class FreelanceJobs {
    String domain , field , applywithin , salary , skills;

    public FreelanceJobs(String domain, String field, String applywithin, String salary, String skills) {
        this.domain = domain;
        this.field = field;
        this.applywithin = applywithin;
        this.salary = salary;
        this.skills = skills;
    }

    public FreelanceJobs() {

    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getApplywithin() {
        return applywithin;
    }

    public void setApplywithin(String applywithin) {
        this.applywithin = applywithin;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

