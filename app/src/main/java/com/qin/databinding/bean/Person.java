package com.qin.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableMap;
import com.qin.databinding.BR;

/**
 * Create by qindl
 * on 2018/11/7
 */
public class Person extends BaseObservable {
    private String name;
    private int age;
    public ObservableBoolean isMan = new ObservableBoolean();
    private ObservableMap<String, String> hobby = new ObservableArrayMap<>();

    public Person(String name, int age, boolean isMan, String hobby) {
        this.name = name;
        this.age = age;
        this.isMan.set(isMan);
        this.hobby.put("hobby",hobby);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public ObservableMap<String, String> getHobby() {
        return hobby;
    }

    public void setHobby(ObservableMap<String, String> hobby) {
        this.hobby = hobby;
    }

    public ObservableBoolean getIsMan() {
        return isMan;
    }

    public void setIsMan(ObservableBoolean isMan) {
        this.isMan = isMan;
    }


}
