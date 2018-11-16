package com.qin.databinding.mv.model;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class DBHelper {
    private static DBHelper dbHelper = new DBHelper();
    private static final String DB_NAME = "db_name";
    private DB mDb;

    private DBHelper(){}
    public static DBHelper getInstance(){
        return dbHelper;
    }

    public void init(Context context){
        mDb = Room.databaseBuilder(context.getApplicationContext(), DB.class, DB_NAME).build();
    }

    public DB getDB(){
        return mDb;
    }
}
