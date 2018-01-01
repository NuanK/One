package com.bwie.one.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.one.R;
import com.bwie.one.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class My1Adapter extends RecyclerView.Adapter<My1Adapter.ViewHolder> {
    private Context context;
    private List<UserBean.DataBean.Ad5Bean> ad5;

    public My1Adapter(Context context, List<UserBean.DataBean.Ad5Bean> ad5) {
        this.context = context;
        this.ad5 = ad5;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View view = LayoutInflater.from(context).inflate(R.layout.r1, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri parse = Uri.parse(ad5.get(position).getImage());
        holder.sim1.setImageURI(parse);
        holder.text.setText(ad5.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ad5.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sim1;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            sim1 = (SimpleDraweeView) itemView.findViewById(R.id.sim1);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
