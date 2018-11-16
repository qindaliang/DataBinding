package com.qin.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;

import com.qin.databinding.bean.Person;
import com.qin.databinding.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVIewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding mBinding;
    private RecyclerViewAdapter mAdapter;

    public class Presenter {
        public void addItem(View view) {
            mAdapter.addItem(new Person("GGGG", 40, true, "pingpang"));
        }
        public void deleteItem(View view) {
            mAdapter.deleteItem();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        mBinding.setPresenter(new Presenter());
        initView();
        initData();
    }

    private void initData() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Person("QQQQ", 20, false, "basketball"));
        }
        mAdapter.setData(list);
    }

    private void initView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(this);
        mBinding.recyclerView.getItemAnimator().setChangeDuration(0);
       // ((SimpleItemAnimator)mBinding.recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mBinding.recyclerView.setAdapter(mAdapter);
    }


}
