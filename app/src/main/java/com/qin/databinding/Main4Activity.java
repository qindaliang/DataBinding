package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import com.qin.databinding.bean.User;
import com.qin.databinding.databinding.ActivityMain3Binding;
import com.qin.databinding.databinding.ActivityMain4Binding;

import java.util.Random;

/**
 * 双向数据绑定，事件绑定
 */
public class Main4Activity extends AppCompatActivity {

    private ActivityMain4Binding mBinding;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main4);
        mUser = new User("利好", "man", 123465789, 20);
        mBinding.setUser(mUser);
        mBinding.setHandle(new Handle());
    }

    public class Handle{
        public void afterTextChanged(Editable editable){
            mUser.setName(editable.toString());
            mBinding.setUser(mUser);
        }
    }
}
