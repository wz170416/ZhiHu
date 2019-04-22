package com.example.lenovo.mvp_cou.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.active.ShowActivity;
import com.example.lenovo.mvp_cou.adapter.VpGoldAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.base.Constants;
import com.example.lenovo.mvp_cou.bean.GoldBeans;
import com.example.lenovo.mvp_cou.present.GoldP;
import com.example.lenovo.mvp_cou.view.GankV;
import com.example.lenovo.mvp_cou.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFragment extends BaseFragment<GoldV, GoldP> implements GoldV {

    @BindView(R.id.gold_tab)
    TabLayout goldTab;
    @BindView(R.id.gold_iv)
    ImageView goldIv;
    @BindView(R.id.gold_vp)
    ViewPager goldVp;
    private ArrayList<GoldBeans> goldBeans;
    private ArrayList<BaseFragment> fragments;
    private VpGoldAdapter adapter;

    @Override
    protected GoldP initPresent() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    protected void initView() {
        initTitie();
        setFragments();
    }

    private void setFragments() {
        initFragment();
        adapter = new VpGoldAdapter(getChildFragmentManager(), fragments, goldBeans);
        goldVp.setAdapter(adapter);
        goldTab.setupWithViewPager(goldVp);
    }

    private void initFragment() {
        fragments = new ArrayList<>();

        for (int i = 0; i < goldBeans.size(); i++) {
            GoldBeans beans = goldBeans.get(i);
            if (beans.isChecked) {
                fragments.add(GoldDetailFragmet.getInstance(beans.title));

            }

        }
    }

    private void initTitie() {
        goldBeans = new ArrayList<>();
        goldBeans.add(new GoldBeans("工具资源", true));
        goldBeans.add(new GoldBeans("Android", true));
        goldBeans.add(new GoldBeans("iOS", true));
        goldBeans.add(new GoldBeans("设计", true));
        goldBeans.add(new GoldBeans("产品", true));
        goldBeans.add(new GoldBeans("阅读", true));
        goldBeans.add(new GoldBeans("前端", true));
        goldBeans.add(new GoldBeans("后端", true));

    }

    @OnClick({R.id.gold_iv})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.gold_iv:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
       // getActivity().startActivityForResult();
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constants.DATA,goldBeans);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!= null){
            if (requestCode == 100 && resultCode == Activity.RESULT_OK){
                goldBeans = (ArrayList<GoldBeans>) data.getSerializableExtra(Constants.DATA);
                //刷新界面
                setFragments();

            }
        }
    }
}
