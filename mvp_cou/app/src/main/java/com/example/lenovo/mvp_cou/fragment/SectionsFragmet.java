package com.example.lenovo.mvp_cou.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.RiBaoAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.ZhuangLang_Ribao;
import com.example.lenovo.mvp_cou.present.DailyNewsP;
import com.example.lenovo.mvp_cou.present.EmptyP;
import com.example.lenovo.mvp_cou.present.SectionP;
import com.example.lenovo.mvp_cou.view.DailyNewsV;
import com.example.lenovo.mvp_cou.view.EmptyV;
import com.example.lenovo.mvp_cou.view.SectionV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragmet extends BaseFragment<SectionV, SectionP> implements SectionV {

    @BindView(R.id.section_recy)
    RecyclerView recy;

    private ArrayList<ZhuangLang_Ribao.DataBean> dataBeans;
    private RiBaoAdapter riBaoAdapter;

    @Override
    protected SectionP initPresent() {
        return new SectionP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setions;
    }

    @Override
    protected void initView() {
        GridLayoutManager grid = new GridLayoutManager(getContext(), 2);
        recy.setLayoutManager(grid);
        dataBeans = new ArrayList<>();
        riBaoAdapter = new RiBaoAdapter(dataBeans,getActivity());
        recy.setAdapter(riBaoAdapter);
    }

    @Override
    protected void initData() {
        present.getData();
    }

    @Override
    public void setData(ZhuangLang_Ribao loginBean) {
        List<ZhuangLang_Ribao.DataBean> data = loginBean.getData();
        dataBeans.addAll(data);
        riBaoAdapter.setRibao(dataBeans);
        riBaoAdapter.notifyDataSetChanged();
    }
}
