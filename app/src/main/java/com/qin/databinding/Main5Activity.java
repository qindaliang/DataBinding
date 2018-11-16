package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qin.databinding.databinding.ActivityMain2Binding;
import com.qin.databinding.databinding.ActivityMain5Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合使用，单项数据绑定
 */
public class Main5Activity extends AppCompatActivity {

    private ActivityMain5Binding mBinding;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main5);

        mList = new ArrayList<>();
        mList.add("first");
        mList.add("second");
        mList.add("second");
        mList.add("second");
        mList.add("second");
        mBinding.setList(mList);

        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < mList.size() ; i++){
            builder.append(mList.get(i));
        }

        ObservableMap<String,String> observableMap = new ObservableArrayMap<>();
        observableMap.put("ob","niu" );

        mBinding.setObservableMap(observableMap);

        mBinding.setListString(builder.toString());

        Map<String,String> map = new HashMap<>();
        map.put("first", "one");
        map.put("second", "two");

        mBinding.setMap(map);
    }


}
