package com.example.jobhunter.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.GeoPoint;

public class Jobs {
    String jobname , companyname , location , experience , salary , applyby ,jobdesc , companydesc , contact , field ;
    GeoPoint geotag;

    public Jobs(String jobname, String companyname, String location, String experience, String salary, String applyby, String jobdesc, String companydesc, String contact, String field, GeoPoint geotag) {
        this.jobname = jobname;
        this.companyname = companyname;
        this.location = location;
        this.experience = experience;
        this.salary = salary;
        this.applyby = applyby;
        this.jobdesc = jobdesc;
        this.companydesc = companydesc;
        this.contact = contact;
        this.field = field;
        this.geotag = geotag;
    }

    public Jobs() {
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getCompanydesc() {
        return companydesc;
    }

    public void setCompanydesc(String companydesc) {
        this.companydesc = companydesc;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public GeoPoint getGeotag() {
        return geotag;
    }

    public void setGeotag(GeoPoint geotag) {
        this.geotag = geotag;
    }
}
