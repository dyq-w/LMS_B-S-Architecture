package com.dyq.bookmgr.dao;

/**
 * @author dtdyq
 * @create 2022-03-21 16:26
 **/
public class Book {
    private int id;
    private String name;
    private String author;
    private String press;
    private long publicTime;
    private String category;
    private String site;
    private int reserve;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public long getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(long publicTime) {
        this.publicTime = publicTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", publicTime=" + publicTime +
                ", category='" + category + '\'' +
                ", site='" + site + '\'' +
                ", reserve=" + reserve +
                ", rate=" + rate +
                '}';
    }
}
