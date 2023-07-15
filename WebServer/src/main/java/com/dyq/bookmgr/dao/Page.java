package com.dyq.bookmgr.dao;

public class Page {
    private int currentPages;
    private int pageSize;


    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPages=" + currentPages +
                ", pageSize=" + pageSize +
                '}';
    }
}
