package com.lx.abcdemo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lixiang on 2017/3/13.
 */

public class UserOpenHelper extends SQLiteOpenHelper{

    public UserOpenHelper(Context context) {
        super(context, "user.db", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id Integer primary key autoincrement,name varchar(20),number varchar(50),address varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("alter table user add account varchar(20)");
    }
}
