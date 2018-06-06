package com.jiuyan.lifecyclecomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * $desc$
 *
 * @author wuzhao
 * @Date 2018/6/6
 * @mail： wuzhao@in66.com
 */
public class LocationManager implements LifecycleObserver {
    public interface Callback {
        /**
         * callback
         */
        void onCallback();
    }

    private Lifecycle lifecycle;
    private WeakReference<Callback> callbackOwner;

    public LocationManager(@NonNull Lifecycle lifecycle, Callback callback) {
        this.lifecycle = lifecycle;
        this.callbackOwner = new WeakReference<>(callback);
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void start() {
        Log.d("wuzhao", "wuzhao test LocationManager-start()");
        doSomeWork();
    }

    public void enable() {
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Log.d("wuzhao", "wuzhao test LocationManager-enable()");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stop() {
        Log.d("wuzhao", "wuzhao test LocationManager-stop()");
    }


    private void doSomeWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    if (callbackOwner.get() != null && lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        callbackOwner.get().onCallback();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
