package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.ZhuangLang_Ribao;

import java.util.ArrayList;

public class RiBaoAdapter extends RecyclerView.Adapter<RiBaoAdapter.ViewHolder> {
    ArrayList<ZhuangLang_Ribao.DataBean> ribao;
    Context context;

    public RiBaoAdapter(ArrayList<ZhuangLang_Ribao.DataBean> ribao, Context context) {
        this.ribao = ribao;
        this.context = context;
    }

    public void setRibao(ArrayList<ZhuangLang_Ribao.DataBean> ribao) {
        this.ribao = ribao;
    }

    @NonNull
    @Override
    public RiBaoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ribao, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiBaoAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(ribao.get(position).getThumbnail()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return ribao.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ribao_iv);
        }
    }
}
