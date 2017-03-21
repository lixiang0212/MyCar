package com.lx.abcdemo.manager;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.CarC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class DataChooseManager {
    private static DataChooseManager dataManager;

    private DataChooseManager() {
    }
    public static DataChooseManager getInstance(){
        if(dataManager==null){
            dataManager = new DataChooseManager();
        }
        return dataManager;
    }

    public  List<String> getData(){
        List<String> data = new ArrayList<>();
        data.add("常用配件");
        data.add("全部配件");
        return data;
    }

    public  List<String> getTData(int number){
        List<String> data = new ArrayList<>();
        if (number==0){
            data.add("发动机(引擎)");
            data.add("变速箱(波箱)");
            data.add("前嘴(前脸)");
            data.add("发电机");
            data.add("空调泵");
            data.add("节气门");
            data.add("方向机");
            data.add("方向助力泵");
            data.add("ABS泵");
            data.add("三元催化器");
            data.add("排气管前节");
        }else if(number==1){
            data.add("发动机(引擎)");
            data.add("机仓");
            data.add("仪表台");
            data.add("内饰");
            data.add("车门");
            data.add("车壳");
            data.add("倒车镜");
            data.add("变速箱(波箱)");
            data.add("前嘴(前脸)");
            data.add("发电机");
            data.add("空调泵");
            data.add("节气门");
            data.add("方向机");
            data.add("方向助力泵");
            data.add("ABS泵");
            data.add("三元催化器");
            data.add("排气管前节");
        }
        return data;
    }
}
