package com.dyq.bookmgr.dao;

public class ReturnBook {
    private int user_id;
    private String name;
    private String author;
    private int count;
    private int rate;
    private long returnTime;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(long returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "ReturnBook{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", rate=" + rate +
                ", returnTime=" + returnTime +
                '}';
    }
}
