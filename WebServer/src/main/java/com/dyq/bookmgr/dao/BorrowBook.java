package com.dyq.bookmgr.dao;

public class BorrowBook {
    private int user_id;
    private long beginTime;
    private long returnTime;
    private int count;
    private String name;
    private String author;
    private int rate;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) {
        this.returnTime = returnTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "user_id=" + user_id +
                ", beginTime=" + beginTime +
                ", returnTime=" + returnTime +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", rate=" + rate +
                '}';
    }
}
