package com.lx.abcdemo.manager;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.CarC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class DataLookManager {
    private static DataLookManager dataManager;

    private DataLookManager() {
    }
    public static DataLookManager getInstance(){
        if(dataManager==null){
            dataManager = new DataLookManager();
        }
        return dataManager;
    }

    public  List<Integer> getData(){
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.look_a1);
        data.add(R.drawable.look_a2);
        data.add(R.drawable.look_a3);
        data.add(R.drawable.look_a4);
        data.add(R.drawable.look_a5);
        data.add(R.drawable.look_a6);
        data.add(R.drawable.look_a7);
        data.add(R.drawable.look_a8);
        data.add(R.drawable.look_a9);
        data.add(R.drawable.look_a10);
        return data;
    }
    public  List<Integer> getSData(){
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.look_sa1);
        data.add(R.drawable.look_sa2);
        data.add(R.drawable.look_sa3);
        data.add(R.drawable.look_sa4);
        data.add(R.drawable.look_sa5);
        data.add(R.drawable.look_sa6);
        data.add(R.drawable.look_sa7);
        data.add(R.drawable.look_sa8);
        data.add(R.drawable.look_sa9);
        data.add(R.drawable.look_sa10);
        return data;
    }
}
