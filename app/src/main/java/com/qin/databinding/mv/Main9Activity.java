package com.qin.databinding.mv;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.qin.databinding.R;
import com.qin.databinding.mv.model.DBHelper;
import com.qin.databinding.mv.model.User;
import com.qin.databinding.mv.model.UserRepository;
import com.qin.databinding.mv.model.UserViewModel;

public class Main9Activity extends AppCompatActivity {

    private TextView tvId;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        initView();
        initData();
    }

    private void initView() {
        tvId = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        DBHelper.getInstance().init(this);
        UserRepository.getInstance().init(this);
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser("qindaliang").observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                tvId.setText(String.valueOf(user.getId()));
                tvName.setText(user.getName());
            }
        });
    }
}
