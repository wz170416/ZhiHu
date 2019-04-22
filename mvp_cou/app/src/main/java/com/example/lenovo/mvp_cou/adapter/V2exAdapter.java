package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.bean.DocumentBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V2exAdapter extends RecyclerView.Adapter<V2exAdapter.ViweHolder> {
    private ArrayList<DocumentBean> list;
    private Context context;

    public V2exAdapter(ArrayList<DocumentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViweHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_v2ex, null);
        return new ViweHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViweHolder viweHolder, int i) {
        final DocumentBean documentBean = list.get(i);
        viweHolder.mVxAuthor.setText(documentBean.getAuthor());
        viweHolder.mVxCount.setText(documentBean.getCount());
        viweHolder.mVxLap.setText(documentBean.getLastPerson());
        viweHolder.mVxTab.setText(documentBean.getTab());
        viweHolder.mVxTime.setText(documentBean.getTime());
        viweHolder.mVxTitle.setText(documentBean.getTitle());
        Glide.with(context).load(documentBean.getPic()).into(viweHolder.mVxImg);
        viweHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){}
                onItemClickListener.itemClick(documentBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(ArrayList<DocumentBean> bean) {

        list.addAll(bean);
        notifyDataSetChanged();
    }

    public class ViweHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vx_img)
        ImageView mVxImg;
        @BindView(R.id.vx_author)
        TextView mVxAuthor;
        @BindView(R.id.vx_time)
        TextView mVxTime;
        @BindView(R.id.vx_lap)
        TextView mVxLap;
        @BindView(R.id.vx_count)
        TextView mVxCount;
        @BindView(R.id.vx_tab)
        TextView mVxTab;
        @BindView(R.id.vx_title)
        TextView mVxTitle;
        public ViweHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void itemClick(DocumentBean documentBean);
    }
}
