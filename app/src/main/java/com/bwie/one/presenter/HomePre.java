package com.bwie.one.presenter;

import com.bwie.one.bean.UserBean;


public interface HomePre {
    void onSuccess(UserBean.DataBean data);
    void onFailed(String message);

    void onSuccess2();
    void onFailed2();
}
