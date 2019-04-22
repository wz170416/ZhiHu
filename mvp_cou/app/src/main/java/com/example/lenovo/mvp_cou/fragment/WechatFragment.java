package com.example.lenovo.mvp_cou.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.WeChatAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.WeChatBean;
import com.example.lenovo.mvp_cou.present.WeChatP;
import com.example.lenovo.mvp_cou.view.WeChatV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseFragment<WeChatV, WeChatP> implements WeChatV{


    @BindView(R.id.wc_recy)
    RecyclerView wcRecy;
    private ArrayList<WeChatBean.NewslistBean> list;
    private WeChatAdapter adapter;

    @Override
    protected WeChatP initPresent() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        wcRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new WeChatAdapter(list, getContext());
        wcRecy.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        present.getData();
    }

    @Override
    public void setData(WeChatBean loginBean) {
        List<WeChatBean.NewslistBean> newslist = loginBean.getNewslist();
        list.addAll(newslist);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}
