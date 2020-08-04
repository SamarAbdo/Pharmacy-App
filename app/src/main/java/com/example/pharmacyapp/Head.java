package com.example.pharmacyapp;

public class Head {
    String PharmacyName,PharmacyNum;
    int PharmacyImg;

    public Head(String pharmacyName, String pharmacyNum, int pharmacyImg) {
        PharmacyName = pharmacyName;
        PharmacyNum = pharmacyNum;
        PharmacyImg = pharmacyImg;
    }

    public String getPharmacyName() {
        return PharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        PharmacyName = pharmacyName;
    }

    public String getPharmacyNum() {
        return PharmacyNum;
    }

    public void setPharmacyNum(String pharmacyNum) {
        PharmacyNum = pharmacyNum;
    }

    public int getPharmacyImg() {
        return PharmacyImg;
    }

    public void setPharmacyImg(int pharmacyImg) {
        PharmacyImg = pharmacyImg;
    }
}
