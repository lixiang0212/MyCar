package com.lx.abcdemo.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;

import com.lx.abcdemo.info.User;

/**
 * Created by lixiang on 2017/3/14.
 */

public class UserLocation {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public UserLocation(Context context) {
        sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }
    public void saveUser(User user,Context context,int id){
        if(sp==null){
            sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        }
        editor = sp.edit();
        editor.putString("name",user.getName());
        editor.putString("number",user.getNumber());
        editor.putString("address",user.getAddress());
        editor.putInt("id",id);
        editor.commit();
    }
    public User getUser(Context context){
        if(sp==null){
            sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        }
        String name = sp.getString("name","");
        String number = sp.getString("number","");
        String address = sp.getString("address","请先添加联系人信息");
        int id = sp.getInt("id",-1);
        return new User(name,number,address,id);
    }
}
