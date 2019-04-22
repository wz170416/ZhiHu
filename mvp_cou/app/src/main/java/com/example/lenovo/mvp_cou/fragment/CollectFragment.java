package com.example.lenovo.mvp_cou.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.present.EmptyP;
import com.example.lenovo.mvp_cou.view.EmptyV;

/**
 * A simple {@link Fragment} subclass.
 */
//张宝明
public class CollectFragment extends BaseFragment<EmptyV,EmptyP> {


    @Override
    protected EmptyP initPresent() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

}
