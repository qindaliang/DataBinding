package com.qin.databinding.mv.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Create by qindl
 * on 2018/11/8
 */

@Database(entities = User.class,version = 1,exportSchema = false)
public abstract class DB extends RoomDatabase {

    public abstract UserDao getUserDao();
}
