package com.bwie.one.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.bwie.one.R;
import com.bwie.one.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;


public class MyRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<UserBean.DataBean.Ad1Bean> ad1;
    private List<UserBean.DataBean.Ad5Bean> ad5;
    private List<UserBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList;
    private List<UserBean.DataBean.SubjectsBean> subjects;

    public MyRcAdapter(Context context, List<UserBean.DataBean.Ad1Bean> ad1, List<UserBean.DataBean.Ad5Bean> ad5, List<UserBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList, List<UserBean.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.ad1 = ad1;
        this.ad5 = ad5;
        this.activityInfoList = activityInfoList;
        this.subjects = subjects;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        } else {
            return 5;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.return6, null);
            ViewHolder6 viewHolder = new ViewHolder6(view);
            return viewHolder;

        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.return1, null);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;

        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.return2, null);
            ViewHolder2 viewHolder = new ViewHolder2(view);
            return viewHolder;

        } else if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.return3, null);
            ViewHolder3 viewHolder = new ViewHolder3(view);
            return viewHolder;

        } else if (viewType == 4) {
            View view = LayoutInflater.from(context).inflate(R.layout.return4, null);
            ViewHolder4 viewHolder = new ViewHolder4(view);
            return viewHolder;

        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.return5, null);
            ViewHolder5 viewHolder = new ViewHolder5(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder6) {
            ViewHolder6 v6 = (ViewHolder6) holder;
            v6.return6.setAdapter(new MyImgAdapter(context, ad1));
        } else if (holder instanceof ViewHolder) {
            ViewHolder v = (ViewHolder) holder;
            v.return1.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
            v.return1.setAdapter(new My1Adapter(context, ad5));
        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 v2 = (ViewHolder2) holder;
            v2.return2.setText("热门活动");
        } else if (holder instanceof ViewHolder3) {
            ViewHolder3 v3 = (ViewHolder3) holder;
            v3.return3.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
            v3.return3.setAdapter(new My3Adapter(context, activityInfoList));

        } else if (holder instanceof ViewHolder4) {
            ViewHolder4 v4 = (ViewHolder4) holder;
            v4.return4.setText("热门专题");
        } else  {
            ViewHolder5 v5 = (ViewHolder5) holder;
            v5.return5.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false));
            v5.return5.setAdapter(new My5Adapter(context, subjects));
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView return1;

        public ViewHolder(View itemView) {
            super(itemView);
            return1 = (RecyclerView) itemView.findViewById(R.id.return1);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView return2;

        public ViewHolder2(View itemView) {
            super(itemView);
            return2 = (TextView) itemView.findViewById(R.id.return2);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        RecyclerView return3;

        public ViewHolder3(View itemView) {
            super(itemView);
            return3 = (RecyclerView) itemView.findViewById(R.id.return3);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {
        TextView return4;

        public ViewHolder4(View itemView) {
            super(itemView);
            return4 = (TextView) itemView.findViewById(R.id.return4);
        }
    }

    class ViewHolder5 extends RecyclerView.ViewHolder {
        RecyclerView return5;

        public ViewHolder5(View itemView) {
            super(itemView);
            return5 = (RecyclerView) itemView.findViewById(R.id.return5);
        }
    }

    class ViewHolder6 extends RecyclerView.ViewHolder {
        ViewPager return6;

        public ViewHolder6(View itemView) {
            super(itemView);
            return6 = (ViewPager) itemView.findViewById(R.id.vp);
        }
    }
}
