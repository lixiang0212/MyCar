package com.lx.abcdemo.manager;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.CarC;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class DataCManager {
    private static DataCManager datacManager;

    private DataCManager() {
    }
    public static DataCManager getInstance(){
        if(datacManager==null){
            datacManager = new DataCManager();
        }
        return datacManager;
    }

    public  List<Integer> getTimeData(){
        List<Integer> data = new ArrayList<>();
        for (int i = 2017;i>2008;i--){
            data.add(i);
        }
        return data;
    }

    public  List<CarC> getCarCData(){
        List<CarC> data = new ArrayList<>();
        for (int i = 1;i<10;i++){
            data.add(new CarC(R.drawable.rr8,(1+i*0.1)+"L","手动GLX-i"));
        }
        return data;
    }
}
