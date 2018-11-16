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
public class UserRepository1 {

    public static UserRepository1 repository = new UserRepository1();

    private UserRepository1(){}

    public static UserRepository1 getInstance(){
        return repository;
    }

    public LiveData<User> getUserInfo(String name){
        UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);

        final MutableLiveData<User> user = new MutableLiveData<>();

        userApi.getUserInfo(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return user;
    }
}
