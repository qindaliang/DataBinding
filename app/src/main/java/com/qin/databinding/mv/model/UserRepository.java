package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class UserRepository {

    private Context mContext;
    private UserDataSource localData = LocalUserDataSource.getInstance();
    private UserDataSource remoteData = RemoteUserDataSource.getInstance();

    private static final UserRepository instance = new UserRepository();
    private UserRepository() {
    }
    public static UserRepository getInstance() {
        return instance;
    }

    public void init(Context context){
        this.mContext = context;
    }

    public LiveData<User> getUserInfo(String username){
        if (NetworkUtils.isConnected(mContext)){
           return remoteData.queryUser(username);
        }else{
            return localData.queryUser(username);
        }
    }
}
