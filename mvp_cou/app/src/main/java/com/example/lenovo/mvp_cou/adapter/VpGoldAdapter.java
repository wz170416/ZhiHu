package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.GoldBeans;

import java.util.ArrayList;

public class VpGoldAdapter extends FragmentStatePagerAdapter {


    private ArrayList<BaseFragment> mfragments;
    private ArrayList<GoldBeans> mtitles;
    private ArrayList<String> mNewTitle = new ArrayList<>();

    public VpGoldAdapter(FragmentManager fm,
                         ArrayList<BaseFragment> fragments,
                         ArrayList<GoldBeans> titles) {
        super(fm);
        mfragments = fragments;
        mtitles = titles;
        for (int i = 0; i < mtitles.size(); i++) {
            GoldBeans goldBeans = mtitles.get(i);
            if (goldBeans.isChecked){
                mNewTitle.add(goldBeans.title);
            }

        }
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNewTitle.get(position);
    }
}
