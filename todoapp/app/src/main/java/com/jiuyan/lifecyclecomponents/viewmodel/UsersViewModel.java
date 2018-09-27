package com.jiuyan.lifecyclecomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jiuyan.lifecyclecomponents.viewmodel.model.User;

/**
 * $desc$
 *
 * @author wuzhao
 * @Date 2018/6/6
 * @mail： wuzhao@in66.com
 */
public class UsersViewModel extends ViewModel {
    private MutableLiveData<User> userLiveData;

    public LiveData<User> getUser() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();

        }
        loadUser();
        return userLiveData;
    }

    private void loadUser() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                user.name = "new name from server";
                userLiveData.postValue(user);

            }
        }).start();
    }

}


