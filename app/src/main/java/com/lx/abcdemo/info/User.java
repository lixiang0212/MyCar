package com.lx.abcdemo.info;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/3/13.
 */

public class User implements Serializable{
    private String name;
    private String number;
    private String address;
    private int id;
    private boolean selected;

    public User(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
        selected=false;
    }

    public User(String name, String number, String address, int id) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.id=id;
        selected=false;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
