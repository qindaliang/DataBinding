package com.qin.databinding.mv.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Create by qindl
 * on 2018/11/8
 */
public interface UserApi {
    @GET("/users/{username}")
    Call<User> getUserInfo(@Path("username")String name);
}
