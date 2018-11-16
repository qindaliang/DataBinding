package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class UserViewModel extends ViewModel {


    private LiveData<User> mUserInfo;

    public LiveData<User> getUser(String name) {
        if (mUserInfo == null) {
            mUserInfo = UserRepository.getInstance().getUserInfo(name);
        }
        return mUserInfo;
    }

    public void setUserName(String name) {

    }
}
