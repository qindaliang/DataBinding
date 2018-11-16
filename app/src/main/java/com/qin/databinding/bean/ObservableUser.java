package com.qin.databinding.bean;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.PropertyChangeRegistry;

import com.qin.databinding.BR;

/**
 * Create by qindl
 * on 2018/11/7
 */
public class ObservableUser{
    private ObservableField<String> name;
    private ObservableInt age;

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
    }

    public ObservableUser(String name, int age) {
        this.name = new ObservableField<String>(name);
        this.age = new ObservableInt(age);
    }
}
