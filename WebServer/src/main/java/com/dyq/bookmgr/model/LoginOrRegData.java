package com.dyq.bookmgr.model;

/**
 * @author dtdyq
 * @create 2022-03-21 19:57
 **/
public class LoginOrRegData {
    private String name;
    private String password;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "LoginOrRegData{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", mail='" + mail + '\'' +
            '}';
    }
}
