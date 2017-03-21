package com.lx.abcdemo.info;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/3/14.
 */

public class Order implements Serializable{
    private int id;
    private int number;
    private String status;
    private int picUrl;
    private String title;
    private double price;
    private int size;
    private int time;

    public Order(int id, int number, String status, int picUrl, String title, double price, int size, int time) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.picUrl = picUrl;
        this.title = title;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public Order(int number, int picUrl, String title, double price, int size, int time, String status) {
        this.number = number;
        this.picUrl = picUrl;
        this.title = title;
        this.price = price;
        this.size = size;
        this.time = time;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
