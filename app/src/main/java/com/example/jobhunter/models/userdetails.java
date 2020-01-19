package com.example.jobhunter.models;

public class userdetails {
    String name,email,qual,contact,course,lang,percent;

    public userdetails(String name, String email, String qual, String contact, String course, String lang, String percent) {
        this.name = name;
        this.email = email;
        this.qual = qual;
        this.contact = contact;
        this.course = course;
        this.lang = lang;
        this.percent = percent;
    }

    public userdetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

