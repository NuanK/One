package com.bwie.one.presenter;

import com.bwie.one.bean.UserBean;
import com.bwie.one.model.HomeModel;
import com.bwie.one.view.HomeView;


public class HomePresenter implements HomePre {
    private HomeView homeView;
    private HomeModel homeModel;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }

    public void getLun(){
        homeModel.getLun(this);
    }

    @Override
    public void onSuccess(UserBean.DataBean data) {
        homeView.onSuccess(data);
    }

    @Override
    public void onFailed(String message) {
        homeView.onFailed(message);
    }

    @Override
    public void onSuccess2() {

    }

    @Override
    public void onFailed2() {

    }
}
