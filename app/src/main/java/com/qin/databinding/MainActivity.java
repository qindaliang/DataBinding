package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.qin.databinding.bean.User;
import com.qin.databinding.databinding.ActivityMainBinding;

import java.util.Random;

/**
 * 单向数据绑定
 * 使用继承osbervable
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUser = new User("利好", "man", 123465789, 20);
        mBinding.setUser(mUser);
        //处理点击时间关键代码，自定义view等需要有setter方法
        mBinding.setHandleclick(new handleClick());
        //监听更新UI显示变化后的操作，实体类如集成BaseObservable直接使用，若为Observable，需要自己处理多线程同步问题，并处理addOnPropertyChangedCallback回调问题
        mUser.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                switch (propertyId) {
                    case BR.age:
                        Toast.makeText(MainActivity.this,mUser.getAge()+"",Toast.LENGTH_SHORT).show();
                        break;
                    case BR.name:
                        Toast.makeText(MainActivity.this,mUser.getName(),Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }

    public class handleClick {
        public void changeName() {
            mUser.setName("SSS" + new Random().nextInt(10000));
        }

        public void changeAge() {
            mUser.setAge(new Random().nextInt(10000));
        }
    }
}
