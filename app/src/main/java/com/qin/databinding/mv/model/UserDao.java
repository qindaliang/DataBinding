package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Create by qindl
 * on 2018/11/8
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long addUser(User user);

    @Query("select * from user where login = :username")
    LiveData<User> queryUser(String username);
}
