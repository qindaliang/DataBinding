package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qin.databinding.bean.Person;
import com.qin.databinding.databinding.ActivityMain2Binding;
import com.qin.databinding.databinding.ActivityMain7Binding;

public class Main7Activity extends AppCompatActivity {

    private ActivityMain7Binding mBinding;
    private Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main7);
        mPerson = new Person("QQQQ",20,false,"basketball");
        mBinding.setPerson(mPerson);
        mBinding.setPresenter(new Presenter());
        mBinding.viewstub.getViewStub().inflate();
    }

    public class Presenter{
        //方法参数要与原来一直，方法名称无所谓（建议一致）
        public void onTextChange(CharSequence s, int start, int before, int count){
            mPerson.setName(s.toString());
            mPerson.getIsMan().set(!mPerson.getIsMan().get());
        }

        public void onClick(View view){

            Toast.makeText(Main7Activity.this,"view" ,Toast.LENGTH_SHORT).show();
        }

        public void onClickShow(String name){
            Toast.makeText(Main7Activity.this,name ,Toast.LENGTH_SHORT).show();
        }
    }
}
