package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qin.databinding.bean.ObservableUser;
import com.qin.databinding.databinding.ActivityMain2Binding;
import com.qin.databinding.databinding.ActivityMain3Binding;

import java.util.Random;

/**
 * 双向数据绑定
 */
public class Main3Activity extends AppCompatActivity {

    private ActivityMain3Binding mBinding;
    private ObservableUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        mUser = new ObservableUser("ndifsdf",210);
        mBinding.setUser(mUser);
        mBinding.setHandle(new Handle());
    }

    public class Handle{
        public void changeName(){
            mUser.getName().set(new Random().nextInt(100)+"");
        }
    }
}
