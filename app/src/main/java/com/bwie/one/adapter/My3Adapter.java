package com.bwie.one.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.one.R;
import com.bwie.one.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class My3Adapter extends RecyclerView.Adapter<My3Adapter.ViewHolder> {
    private Context context;
    private List<UserBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList;

    public My3Adapter(Context context, List<UserBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList) {
        this.context = context;
        this.activityInfoList = activityInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View view= LayoutInflater.from(context).inflate(R.layout.r3,null);
        ViewHolder v=new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri parse = Uri.parse(activityInfoList.get(position).getActivityImg());
        holder.img.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return activityInfoList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView img;
        public ViewHolder(View itemView) {
            super(itemView);
             img = (SimpleDraweeView) itemView.findViewById(R.id.r3img);
        }
    }
}
