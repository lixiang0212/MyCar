package com.lx.abcdemo.info;

/**
 * Created by lixiang on 2017/3/6.
 */

public class Car {
    private int type;
    private int picId;
    private String name;

    public Car(int type, int picId, String name) {
        this.type = type;
        this.picId = picId;
        this.name = name;
    }

    public Car(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
