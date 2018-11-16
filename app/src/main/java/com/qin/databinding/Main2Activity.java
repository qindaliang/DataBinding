package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qin.databinding.bean.ObservableUser;
import com.qin.databinding.databinding.ActivityMain2Binding;

import java.util.Random;

/**
 * 单项数据绑定，使用提供的osbervableField<>等 </>
 */
public class Main2Activity extends AppCompatActivity {

    private ObservableUser mUser;
    private ActivityMain2Binding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        mUser = new ObservableUser("qin",20);
        mBinding.setUser(mUser);
        mBinding.setHandleclick(new handleClick());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }

    public class handleClick{
        public void changeName() {
            mUser.getName().set("改变后的值"+new Random().nextInt(10000));
        }

        public void changeAge() {

        }
    }
}
