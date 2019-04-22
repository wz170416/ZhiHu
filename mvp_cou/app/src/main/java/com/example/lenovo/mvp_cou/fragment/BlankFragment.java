package com.example.lenovo.mvp_cou.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.active.ShowActivity;
import com.example.lenovo.mvp_cou.adapter.V2exAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.DocumentBean;
import com.example.lenovo.mvp_cou.net.ApiService;
import com.example.lenovo.mvp_cou.present.BlankPresenter;
import com.example.lenovo.mvp_cou.view.BlankView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment<BlankView, BlankPresenter> implements BlankView {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private V2exAdapter adapter;
    private String href;


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstant(String href) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle=new Bundle();
        bundle.putString("href",href);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }



    @Override
    protected void initView() {
        ArrayList<DocumentBean> list = new ArrayList<>();
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new V2exAdapter(list, getContext());
        mRlv.setAdapter(adapter);
        Bundle bundle = getArguments();
        href = bundle.getString("href");
        adapter.setOnItemClickListener(new V2exAdapter.OnItemClickListener() {
            @Override
            public void itemClick(DocumentBean documentBean) {
                Intent intent = new Intent(getContext(), ShowActivity.class);
                intent.putExtra("url", ApiService.mUrl+documentBean.getUrl());
                intent.putExtra("title",documentBean.getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    protected BlankPresenter initPresent() {
        return new BlankPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initData() {
        present.getBlank(href);
    }

    @Override
    public void updateDoc(final ArrayList<DocumentBean> bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setAll(bean);
            }
        });
    }
}
