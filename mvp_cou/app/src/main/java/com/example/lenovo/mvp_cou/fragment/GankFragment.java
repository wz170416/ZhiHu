package com.example.lenovo.mvp_cou.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.present.GankP;
import com.example.lenovo.mvp_cou.view.GankV;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment<GankV,GankP> {
    @Override
    protected GankP initPresent() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

}
