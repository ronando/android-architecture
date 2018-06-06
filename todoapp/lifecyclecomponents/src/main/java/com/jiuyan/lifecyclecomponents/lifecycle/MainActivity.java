package com.jiuyan.lifecyclecomponents.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jiuyan.lifecyclecomponents.R;

/**
 * @author wuzhao
 */
public class MainActivity extends AppCompatActivity {

    private LocationManager mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("wuzhao", "wuzhao test Activity-onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationListener = new LocationManager(this.getLifecycle(), new LocationManager.Callback() {
            @Override
            public void onCallback() {
                //update ui
                Log.d("wuzhao", "wuzhao test Activity-onCallback() update ui");
            }
        });
        mLocationListener.enable();
    }


    @Override
    protected void onDestroy() {
        Log.d("wuzhao", "wuzhao test Activity-onDestroy()");
        super.onDestroy();
    }
}
