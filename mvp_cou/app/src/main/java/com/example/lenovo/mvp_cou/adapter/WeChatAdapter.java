package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.WeChatBean;

import java.util.ArrayList;

public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.ViewHolder> {
    ArrayList<WeChatBean.NewslistBean> list;
    Context context;

    public WeChatAdapter(ArrayList<WeChatBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<WeChatBean.NewslistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wechat, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getTitle());
        holder.tv2.setText(list.get(position).getDescription());
        holder.tv3.setText(list.get(position).getCtime());
        Glide.with(context).load(list.get(position).getPicUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv3;
        private final TextView tv2;
        private final TextView tv1;
        private final ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.wc_iv);
            tv1 = itemView.findViewById(R.id.wc_tv1);
            tv2 = itemView.findViewById(R.id.wc_tv2);
            tv3 = itemView.findViewById(R.id.wc_tv3);
        }
    }
}
