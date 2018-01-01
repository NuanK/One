package com.bwie.one.model;

import com.bwie.one.bean.UserBean;
import com.bwie.one.presenter.HomePre;
import com.bwie.one.utils.OKHttpCallBack;
import com.bwie.one.utils.OKHttpUtils;
import com.google.gson.Gson;

import java.util.HashMap;


public class HomeModel {
    OKHttpUtils okHttpUtils = OKHttpUtils.getInstance();
    HashMap<String, String> map = new HashMap<>();

    public void getLun(final HomePre homePre) {
        map.put("uri","homepage");
        okHttpUtils.doGet("http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611", map, new OKHttpCallBack() {
            @Override
            public void onSuccess(String str) {
                Gson gson=new Gson();
                UserBean userBean = gson.fromJson(str, UserBean.class);
                UserBean.DataBean data = userBean.getData();
                homePre.onSuccess(data);
            }

            @Override
            public void onFailed(String message) {
                homePre.onFailed(message);
            }
        });
    }
}
