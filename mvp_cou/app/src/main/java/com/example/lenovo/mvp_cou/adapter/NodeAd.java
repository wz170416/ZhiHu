package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.active.NodeNaviActivity;
import com.example.lenovo.mvp_cou.bean.V2EXBean;
import com.example.lenovo.mvp_cou.utils.ToastUtil;
import com.example.lenovo.mvp_cou.weight.FlowLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NodeAd extends RecyclerView.Adapter<NodeAd.ViewHodler> {
    private Context context;
    private ArrayList<V2EXBean.DataBean> list;

    public NodeAd(Context context, ArrayList<V2EXBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_navi, null);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        List<V2EXBean.DataBean.ArticlesBean> articles = list.get(i).getArticles();
        if (articles != null && articles.size() > 0) {
            for (int j = 0; j < articles.size(); j++) {
                final String title = articles.get(j).getTitle();
                TextView lable = (TextView) View.inflate(context, R.layout.item_label, null);
                lable.setText(title);
                lable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showLong(title);
                    }
                });
               viewHodler.mFl.addView(lable);
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setAll(List<V2EXBean.DataBean> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
      @BindView(R.id.fl)
      FlowLayout mFl;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
