package com.example.lenovo.mvp_cou.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.lenovo.mvp_cou.base.BaseFragment;

import java.util.ArrayList;

public class VpZhiHuAdapter extends FragmentPagerAdapter {


    private Context mcontext;
    private ArrayList<BaseFragment> mfragments;
    private ArrayList<Integer> mtitles;

    public VpZhiHuAdapter(Context context, FragmentManager fm,
                          ArrayList<BaseFragment> fragments,
                          ArrayList<Integer> titles) {
        super(fm);
        mcontext = context;
        mfragments = fragments;
        mtitles = titles;
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

        return mcontext.getResources().getString(mtitles.get(position));
    }
}
