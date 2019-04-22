package com.example.lenovo.mvp_cou.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.GoldBeans;
import com.example.lenovo.mvp_cou.weight.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvShowAdapter extends RecyclerView.Adapter implements TouchCallBack {
    private ArrayList<GoldBeans> mlist;

    public RlvShowAdapter(ArrayList<GoldBeans> list) {
        mlist = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        final GoldBeans beans = mlist.get(position);
        vh.tv.setText(beans.title);
        vh.sc.setChecked(beans.isChecked);
        vh.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                beans.isChecked = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mlist,fromPosition,toPosition);
        //局部刷新，索乱混乱
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        mlist.remove(position);
        //局部刷新，索乱混乱，越界
        notifyItemRemoved(position);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.show_tv)
        TextView tv;
        @BindView(R.id.show_sc)
        SwitchCompat sc;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
