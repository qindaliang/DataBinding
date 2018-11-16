package com.qin.databinding.mv.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Create by qindl
 * on 2018/11/8
 */
public class RemoteUserDataSource implements UserDataSource {
    private static final RemoteUserDataSource instance = new RemoteUserDataSource();
    private RemoteUserDataSource() {
    }
    public static RemoteUserDataSource getInstance() {
        return instance;
    }

    UserApi mUserApi = RetrofitFactory.getInstance().create(UserApi.class);
    @Override
    public LiveData<User> queryUser(String username) {

        final MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

        mUserApi.getUserInfo(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mutableLiveData.setValue(response.body());
                LocalUserDataSource.getInstance().addUser(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    @Override
    public LiveData<Long> addUser(User user) {
        return null;
    }
}
