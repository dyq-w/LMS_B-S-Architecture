package com.dyq.bookmgr.dao;

public class Borrow {
    private int id;
    private int user_id;
    private int book_id;
    private long begin_time;
    private int borrow_time;
    private long return_time;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public long getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(long begin_time) {
        this.begin_time = begin_time;
    }

    public int getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(int borrow_time) {
        this.borrow_time = borrow_time;
    }

    public long getReturn_time() {
        return return_time;
    }

    public void setReturn_time(long return_time) {
        this.return_time = return_time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", begin_time=" + begin_time +
                ", borrow_time=" + borrow_time +
                ", return_time=" + return_time +
                ", count=" + count +
                '}';
    }
}
