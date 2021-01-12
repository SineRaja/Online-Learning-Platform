package com.example.sha;

public class UserHelperClass {

    String userName, emailID, phoneNo, password;

    public UserHelperClass() {
    }

    public UserHelperClass(String userName, String emailID, String phoneNo, String password) {
        this.userName = userName;
        this.emailID = emailID;
        this.phoneNo = phoneNo;
        this.password = password;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

