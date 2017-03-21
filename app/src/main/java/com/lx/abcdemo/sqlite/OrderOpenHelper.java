package com.lx.abcdemo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lixiang on 2017/3/13.
 */

public class OrderOpenHelper extends SQLiteOpenHelper{

    public OrderOpenHelper(Context context) {
        super(context, "order.db", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ors(id Integer primary key autoincrement," +
                "number Integer," +
                "status varchar(20)," +
                "pic Integer," +
                "title varchar(200)," +
                "price Double," +
                "size Integer," +
                "time Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("alter table user add account varchar(20)");
    }
}
