package com.bwie.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.one.adapter.MyImgAdapter;
import com.bwie.one.adapter.MyRcAdapter;
import com.bwie.one.bean.UserBean;
import com.bwie.one.presenter.HomePresenter;
import com.bwie.one.view.HomeView;
import com.youth.banner.Banner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeView{

    private ImageView mZxing;
    /**
     * 搜索一下
     */
    private EditText mSousuo;
    private ImageView mXiaoxi;
    private RecyclerView mRecy;
    private LinearLayout mActivityMain;

    private HomePresenter homePresenter;
    private MyImgAdapter myImgAdapter;
    private int curentPager = 0;
    private MyRcAdapter myRcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        homePresenter = new HomePresenter(this);
        homePresenter.getLun();
    }

    private void initView() {
        mZxing = (ImageView) findViewById(R.id.Zxing);
        mSousuo = (EditText) findViewById(R.id.sousuo);
        mXiaoxi = (ImageView) findViewById(R.id.xiaoxi);
        mRecy = (RecyclerView) findViewById(R.id.rc);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
    }


    @Override
    public void onSuccess(UserBean.DataBean data) {
        List<UserBean.DataBean.Ad1Bean> ad1 = data.getAd1();
        List<UserBean.DataBean.Ad5Bean> ad5 = data.getAd5();
        List<UserBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList = data.getActivityInfo().getActivityInfoList();
        List<UserBean.DataBean.SubjectsBean> subjects = data.getSubjects();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(linearLayoutManager);
        myRcAdapter = new MyRcAdapter(this,ad1,ad5,activityInfoList,subjects);
        mRecy.setAdapter(myRcAdapter);
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onSuccess2() {

    }

    @Override
    public void onFailed2() {

    }
}
