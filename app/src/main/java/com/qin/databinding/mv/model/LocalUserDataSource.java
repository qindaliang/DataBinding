package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class LocalUserDataSource implements UserDataSource{

    private static final LocalUserDataSource instance = new LocalUserDataSource();
    private LocalUserDataSource() {
    }
    public static LocalUserDataSource getInstance() {
        return instance;
    }

    UserService mUserService = UserServiceImpl.getInstance();

    @Override
    public LiveData<User> queryUser(String username) {
        return mUserService.queryUser(username);
    }

    @Override
    public LiveData<Long> addUser(User user) {
        return mUserService.addUser(user);
    }
}
