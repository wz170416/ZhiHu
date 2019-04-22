package com.example.lenovo.mvp_cou.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.HotAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.HotBean;
import com.example.lenovo.mvp_cou.present.EmptyP;
import com.example.lenovo.mvp_cou.present.HotP;
import com.example.lenovo.mvp_cou.view.EmptyV;
import com.example.lenovo.mvp_cou.view.HotV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragmet extends BaseFragment<HotV,HotP> implements HotV{

    @BindView(R.id.hot_recy)
    RecyclerView recy;

    private ArrayList<HotBean.RecentBean> hotBeans;
    private HotAdapter hotAdapter;

    @Override
    protected HotP initPresent() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return  R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        hotBeans = new ArrayList<>();
        //recy.setLayoutManager(new LinearLayoutManager(getContext()));
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        hotAdapter = new HotAdapter(hotBeans, getContext());
        recy.setAdapter(hotAdapter);
    }

    @Override
    protected void initData() {
        present.getData();
    }

    @Override
    public void setData(HotBean loginBean) {
        List<HotBean.RecentBean> recent = loginBean.getRecent();
        hotBeans.addAll(recent);
        hotAdapter.setList(hotBeans);
        hotAdapter.notifyDataSetChanged();
    }
}
