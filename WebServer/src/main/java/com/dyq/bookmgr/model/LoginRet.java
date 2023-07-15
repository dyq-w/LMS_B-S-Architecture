package com.dyq.bookmgr.model;

/**
 * @author dtdyq
 * @create 2022-03-21 18:11
 **/
public class LoginRet {
    private int code;
    private String nameError;
    private String passwordError;
    private String mailError;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getMailError() {
        return mailError;
    }

    public void setMailError(String mailError) {
        this.mailError = mailError;
    }

    @Override
    public String toString() {
        return "LoginRet{" +
            "code=" + code +
            ", nameError='" + nameError + '\'' +
            ", passwordError='" + passwordError + '\'' +
            ", mailError='" + mailError + '\'' +
            '}';
    }
}
