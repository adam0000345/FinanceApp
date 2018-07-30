package com.example.finance.googlesheetsexample.androidlabs.gsheets1;

//MyDataModel


public class MyDataModel {

    private int year;

    private int cftoequity;

    private int difference;

    private int cftofirm;

    //a setter for difference is not required because this is done in Google Sheets


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCashFlowToEquity() {
        return cftoequity;
    }

    public void setCashFlowToEquity(int cftoequity) {
        this.cftoequity = cftoequity;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getCashFlowToFirm() {
        return cftofirm;
    }

    public void setCashFlowToFirm(int cftofirm) {
        this.cftofirm = cftofirm;
    }


}
