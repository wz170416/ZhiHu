package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    ArrayList<HotBean.RecentBean> list;
    Context context;

    public HotAdapter(ArrayList<HotBean.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<HotBean.RecentBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, parent,false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail()).into(holder.iv);
        holder.tv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.hot_iv);
            tv = itemView.findViewById(R.id.hot_tv);
        }
    }
}
