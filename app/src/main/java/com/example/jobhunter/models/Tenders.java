package com.example.jobhunter.models;

public class Tenders {
    String Sector , location , closingdate , tendervalue, refno, tenderdesc;

    public Tenders(String sector, String location, String closingdate, String tendervalue, String refno, String tenderdesc) {
        Sector = sector;
        this.location = location;
        this.closingdate = closingdate;
        this.tendervalue = tendervalue;
        this.refno = refno;
        this.tenderdesc = tenderdesc;
    }

    public Tenders() {
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClosingdate() {
        return closingdate;
    }

    public void setClosingdate(String closingdate) {
        this.closingdate = closingdate;
    }

    public String getTendervalue() {
        return tendervalue;
    }

    public void setTendervalue(String tendervalue) {
        this.tendervalue = tendervalue;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getTenderdesc() {
        return tenderdesc;
    }

    public void setTenderdesc(String tenderdesc) {
        this.tenderdesc = tenderdesc;
    }
}

