package com.bwie.one.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.one.R;
import com.bwie.one.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class MyImgAdapter extends PagerAdapter {
    private Context context;
    private List<UserBean.DataBean.Ad1Bean> ad1;

    public MyImgAdapter(Context context, List<UserBean.DataBean.Ad1Bean> ad1) {
        this.context = context;
        this.ad1 = ad1;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fresco.initialize(context);
        View view=View.inflate(context,R.layout.fresco_layout,null);
        SimpleDraweeView simple = (SimpleDraweeView) view.findViewById(R.id.simple);
        Uri parse = Uri.parse(ad1.get(position%ad1.size()).getImage());
        simple.setImageURI(parse);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
