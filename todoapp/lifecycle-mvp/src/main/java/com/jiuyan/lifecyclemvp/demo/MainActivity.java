package com.jiuyan.lifecyclemvp.demo;

import android.os.Bundle;
import android.widget.Toast;

import com.jiuyan.lifecyclemvp.CreatePresenter;
import com.jiuyan.lifecyclemvp.R;

@CreatePresenter(MainViewPresenter.class)
public class MainActivity extends BaseMvpActivity<IMainView,MainViewPresenter> implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showDiscoverList() {
        Toast.makeText(this,"showDiscoverList called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPeopleList() {
        Toast.makeText(this,"showPeopleList called",Toast.LENGTH_SHORT).show();
    }
}
