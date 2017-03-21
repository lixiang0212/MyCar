package com.lx.abcdemo.sharedpre;

/**
 * Created by lixiang on 2017/3/18.
 */

public class SharedA {
    private static SharedA sharedA;
    private int id=0;
    public SharedA() {
    }
    public static SharedA getInstance(){
        if(sharedA==null){
            sharedA = new SharedA();
        }
        return sharedA;
    }
    public void saveId(int i){
        id=i;
    }
    public int getId(){
        return id;
    }
}
