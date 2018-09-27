package com.jiuyan.lifecyclemvp.demo;

import com.jiuyan.lifecyclemvp.BaseMvpPresenter;

/**
 * $desc$
 *
 * @author wuzhao
 * @Date 2018/6/12
 * @mail： wuzhao@in66.com
 */
public class MainViewPresenter extends BaseMvpPresenter<IMainView> {


    @Override
    public void onAttachMvpView(IMainView mvpView) {
        super.onAttachMvpView(mvpView);
        getPeopleList();
    }

    public void getPeopleList() {
        getMvpView().showPeopleList();
    }


    public void getDiscoverContent() {

    }



}
