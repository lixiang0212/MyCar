package com.lx.abcdemo.info;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/3/15.
 */

public class CarProduct implements Serializable{
    private int picUrl;
    private String name;
    private double price;

    public CarProduct(int picUrl, String name, double price) {
        this.picUrl = picUrl;
        this.name = name;
        this.price = price;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
