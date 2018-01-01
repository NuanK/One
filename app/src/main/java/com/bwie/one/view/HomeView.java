package com.bwie.one.view;

import com.bwie.one.bean.UserBean;


public interface HomeView {
    void onSuccess(UserBean.DataBean data);
    void onFailed(String message);

    void onSuccess2();
    void onFailed2();
}
