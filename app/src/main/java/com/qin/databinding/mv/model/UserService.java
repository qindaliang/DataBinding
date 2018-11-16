package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;

/**
 * Create by qindl
 * on 2018/11/8
 */
public interface UserService {
    LiveData<Long> addUser(User user);

    LiveData<User> queryUser(String username);
}
