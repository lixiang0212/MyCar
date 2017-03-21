package com.lx.abcdemo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lx.abcdemo.info.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2017/3/13.
 */

public class UserSqlUtils {
    private UserOpenHelper userOpenHelper;

    public UserSqlUtils(Context context) {
        userOpenHelper = new UserOpenHelper(context);
    }

    public void addUser(User user){
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("number",user.getNumber());
        values.put("address",user.getAddress());
        db.insert("user",null,values);
        db.close();
    }
    public void deleteUser(int id){
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();
        db.delete("user","id=?",new String[]{id+""});
        db.close();
    }
    public void updateUser(User user){
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("number",user.getNumber());
        values.put("address",user.getAddress());
        db.update("user",values,"id=?",new String[]{user.getId()+""});
        db.close();
    }
    public List<User> queryAll(){
        SQLiteDatabase db = userOpenHelper.getWritableDatabase();
        List<User> users = new ArrayList<>();
        Cursor cursor =db.query("user",null,null,null,null,null,"id ASC");
        if (cursor!=null){
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                users.add(new User(name,number,address,id));
            }
        }
        cursor.close();
        db.close();
        return users;
    }



}
