package com.lx.abcdemo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lx.abcdemo.info.Order;
import com.lx.abcdemo.info.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2017/3/13.
 */

public class OrderSqlUtils {
    private OrderOpenHelper openHelper;

    public OrderSqlUtils(Context context) {
        openHelper=new OrderOpenHelper(context);
    }

    public void addUser(Order order){
        SQLiteDatabase db =openHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number",order.getNumber());
        values.put("status",order.getStatus());
        values.put("pic",order.getPicUrl());
        values.put("title",order.getTitle());
        values.put("price",order.getPrice());
        values.put("size",order.getSize());
        values.put("time",order.getTime());
        db.insert("ors",null,values);
        db.close();
    }
    public void deleteUser(int id){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.delete("ors","id=?",new String[]{id+""});
        db.close();
    }
    public void updateUser(Order order){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number",order.getNumber());
        values.put("status",order.getStatus());
        values.put("pic",order.getPicUrl());
        values.put("title",order.getTitle());
        values.put("price",order.getPrice());
        values.put("size",order.getSize());
        values.put("time",order.getTime());
        db.update("ors",values,"id=?",new String[]{order.getId()+""});
        db.close();
    }
    public List<Order> queryAll(){
        SQLiteDatabase db =openHelper.getWritableDatabase();
        List<Order> orders = new ArrayList<>();
        Cursor cursor =db.query("ors",null,null,null,null,null,"id ASC");
        if (cursor!=null){
            while (cursor.moveToNext()){
                String status = cursor.getString(cursor.getColumnIndex("status"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                int picUrl = cursor.getInt(cursor.getColumnIndex("pic"));
                int size = cursor.getInt(cursor.getColumnIndex("size"));
                int time = cursor.getInt(cursor.getColumnIndex("time"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int number= cursor.getInt(cursor.getColumnIndex("number"));
                Log.i("AAA","ors"+number);
               orders.add(new Order(id,number,status,picUrl,title,price,size,time));
            }

        }
        cursor.close();
        db.close();
        return orders;
    }



}
