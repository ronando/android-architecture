package com.jiuyan.lifecyclecomponents.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jiuyan.lifecyclecomponents.R;
import com.jiuyan.lifecyclecomponents.viewmodel.model.User;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        UsersViewModel userViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                ((TextView)findViewById(R.id.tv_user_info)).setText(user.name);
            }
        });


    }
}
