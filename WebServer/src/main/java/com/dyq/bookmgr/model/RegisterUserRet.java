package com.dyq.bookmgr.model;

public class RegisterUserRet {
    private int code;
    private String nameerror;
    private String passworderror;
    private String ageerror;
    private String emailerror;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameerror() {
        return nameerror;
    }

    public void setNameerror(String nameerror) {
        this.nameerror = nameerror;
    }

    public String getPassworderror() {
        return passworderror;
    }

    public void setPassworderror(String passworderror) {
        this.passworderror = passworderror;
    }

    public String getAgeerror() {
        return ageerror;
    }

    public void setAgeerror(String ageerror) {
        this.ageerror = ageerror;
    }


    public String getEmailerror() {
        return emailerror;
    }

    public void setEmailerror(String emailerror) {
        this.emailerror = emailerror;
    }

    @Override
    public String toString() {
        return "RegisterUserRet{" +
                "code=" + code +
                ", nameerror='" + nameerror + '\'' +
                ", passworderror='" + passworderror + '\'' +
                ", ageerror='" + ageerror + '\'' +
                ", emailerror='" + emailerror + '\'' +
                '}';
    }
}
