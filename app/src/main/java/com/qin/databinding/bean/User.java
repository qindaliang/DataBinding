package com.qin.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.qin.databinding.BR;

import java.util.Random;

/**
 * Create by qindl
 * on 2018/11/7
 */
public class User extends BaseObservable {

    private String name;

    public User(String name, String sex, int phone, int age) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.age = age;
    }

    private String sex;
    private int phone;
    private int age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public void changeName(){
        this.name = "SSS"+new Random().nextInt(10000);
    }
}
