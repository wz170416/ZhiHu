package com.example.lenovo.mvp_cou.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.base.Constants;
import com.example.lenovo.mvp_cou.present.EmptyP;
import com.example.lenovo.mvp_cou.view.EmptyV;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldDetailFragmet extends BaseFragment<EmptyV, EmptyP> implements EmptyV {


    @BindView(R.id.deaily_tv)
    TextView gold;

    private static GoldDetailFragmet goldDetailFragmet;
    public static GoldDetailFragmet getInstance(String text) {
        goldDetailFragmet = new GoldDetailFragmet();

        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, text);
        goldDetailFragmet.setArguments(bundle);
        return goldDetailFragmet;

    }

    @Override
    protected EmptyP initPresent() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gold_detaily;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String data = arguments.getString(Constants.DATA);
        gold.setText(data);
    }
}
