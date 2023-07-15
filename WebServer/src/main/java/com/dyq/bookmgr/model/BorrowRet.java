package com.dyq.bookmgr.model;

public class BorrowRet {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BorrowRet{" +
                "code=" + code +
                '}';
    }
}
