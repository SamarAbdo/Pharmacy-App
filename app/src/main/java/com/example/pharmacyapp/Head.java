package com.example.pharmacyapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Head  implements Parcelable {
    String PharmacyName,PharmacyNum,PharmacyAddress,PharmacyAccount;
    int PharmacyImg;

    public String getPharmacyAddress() {
        return PharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        PharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyAccount() {
        return PharmacyAccount;
    }

    public void setPharmacyAccount(String pharmacyAccount) {
        PharmacyAccount = pharmacyAccount;
    }

    public Head(String pharmacyName, String pharmacyNum, int pharmacyImg,String pharmacyAccount,String pharmacyAddress) {
        PharmacyName = pharmacyName;
        PharmacyNum = pharmacyNum;
        PharmacyImg = pharmacyImg;
        PharmacyAccount=pharmacyAccount;
        PharmacyAddress=pharmacyAddress;
    }

    protected Head(Parcel in) {
        PharmacyName = in.readString();
        PharmacyNum = in.readString();
        PharmacyImg = in.readInt();
    }

    public static final Creator<Head> CREATOR = new Creator<Head>() {
        @Override
        public Head createFromParcel(Parcel in) {
            return new Head(in);
        }

        @Override
        public Head[] newArray(int size) {
            return new Head[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(PharmacyName);
        parcel.writeString(PharmacyNum);
        parcel.writeInt(PharmacyImg);
    }
}
