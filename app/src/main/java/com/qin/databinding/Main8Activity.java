package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qin.databinding.bean.Person;
import com.qin.databinding.databinding.ActivityMain8Binding;

public class Main8Activity extends AppCompatActivity {

    private ActivityMain8Binding mBinding;
    private Boolean isChange;
    private Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main8);
        mPerson = new Person("QQQQ",20,false,"basketball");
        mBinding.setPerson(mPerson);
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter{
        public void change(View view){
            Log.i("TAG", "change: ");
        }

        public void onTextChanged(CharSequence s, int start, int before, int count){
            mPerson.setName(s.toString());
            if (!s.toString().equals("")|| !TextUtils.isEmpty(s)){
                mBinding.setIsChange(true);
            }else{
                mBinding.setIsChange(false);
            }
        }
    }
}
