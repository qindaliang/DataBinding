package com.qin.databinding.mv.model;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private UserDao mUserDao = DBHelper.getInstance().getDB().getUserDao();

    @SuppressLint("StaticFieldLeak")
    @Override
    public LiveData<Long> addUser(final User user) {
        final MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        new AsyncTask<Void,Void,Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                return mUserDao.addUser(user);
            }

            @Override
            protected void onPostExecute(Long aLong) {
                mutableLiveData.setValue(aLong);
            }
        }.execute();
        return mutableLiveData;
    }

    @Override
    public LiveData<User> queryUser(String username) {
        return mUserDao.queryUser(username);
    }
}
