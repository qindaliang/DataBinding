package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;

/**
 * Create by qindl
 * on 2018/11/8
 */
public interface UserDataSource {
    LiveData<User> queryUser(String username);
    LiveData<Long> addUser(User user);
}
