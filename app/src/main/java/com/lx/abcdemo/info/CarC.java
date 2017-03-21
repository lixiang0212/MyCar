package com.lx.abcdemo.info;

/**
 * Created by lixiang on 2017/3/8.
 */

public class CarC {
    private int picId;
    private String size;
    private String kind;

    public CarC(int picId, String size, String kind) {
        this.picId = picId;
        this.size = size;
        this.kind = kind;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
