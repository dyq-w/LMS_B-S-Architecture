package com.dyq.bookmgr.model;

/**
 * @author dtdyq
 * @create 2022-05-08 17:07
 **/
public class ServerRet {
    private int code;
    private String nameerror;
    private String authorerror;
    private String presserror;
    private String publicTimeerror;
    private String siteerror;
    private String reserveerror;


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

    public String getAuthorerror() {
        return authorerror;
    }

    public void setAuthorerror(String authorerror) {
        this.authorerror = authorerror;
    }

    public String getPresserror() {
        return presserror;
    }

    public void setPresserror(String presserror) {
        this.presserror = presserror;
    }

    public String getPublicTimeerror() {
        return publicTimeerror;
    }

    public void setPublicTimeerror(String publicTimeerror) {
        this.publicTimeerror = publicTimeerror;
    }

    public String getSiteerror() {
        return siteerror;
    }

    public void setSiteerror(String siteerror) {
        this.siteerror = siteerror;
    }

    public String getReserveerror() {
        return reserveerror;
    }

    public void setReserveerror(String reserveerror) {
        this.reserveerror = reserveerror;
    }

    @Override
    public String toString() {
        return "ServerRet{" +
                "code=" + code +
                ", nameerror='" + nameerror + '\'' +
                ", authorerror='" + authorerror + '\'' +
                ", presserror='" + presserror + '\'' +
                ", publicTimeerror='" + publicTimeerror + '\'' +
                ", siteerror='" + siteerror + '\'' +
                ", reserveerror='" + reserveerror + '\'' +
                '}';
    }
}
