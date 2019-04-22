package com.example.lenovo.mvp_cou.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.VpZhiHuAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.present.ZhihuP;
import com.example.lenovo.mvp_cou.view.ZhihuV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//张宝明
public class ZhuhuFragment extends BaseFragment<ZhihuV, ZhihuP> implements ZhihuV {

    @BindView(R.id.zhihu_tab)
    TabLayout zhihuTab;
    @BindView(R.id.zhi_vp)
    ViewPager zhiVp;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<Integer> titles;
    private VpZhiHuAdapter zhiHuAdapter;

    @Override
    protected ZhihuP initPresent() {
        return new ZhihuP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zhihu;
    }


    @Override
    protected void initView() {
        initTitles();
        initFragments();
        zhiHuAdapter = new VpZhiHuAdapter(getContext(),getChildFragmentManager(), fragments, titles);
        zhiVp.setAdapter(zhiHuAdapter);
        zhihuTab.setupWithViewPager(zhiVp);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new DailyNewsFragmet());
        fragments.add(new SectionsFragmet());
        fragments.add(new HotFragmet());
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.dailyNews);
        titles.add(R.string.sections);
        titles.add(R.string.hot);
    }
}
