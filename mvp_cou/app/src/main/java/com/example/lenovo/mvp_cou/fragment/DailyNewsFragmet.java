package com.example.lenovo.mvp_cou.fragment;


import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.active.FloatActivity;
import com.example.lenovo.mvp_cou.adapter.RlvDailyNewsAdapter;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.bean.DailyNewsBean;
import com.example.lenovo.mvp_cou.present.DailyNewsP;
import com.example.lenovo.mvp_cou.view.DailyNewsV;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyNewsFragmet extends BaseFragment<DailyNewsV, DailyNewsP> implements DailyNewsV, View.OnClickListener {

    @BindView(R.id.dail_recy)
    RecyclerView re;
    @BindView(R.id.floatbutton)
    FloatingActionButton dd;
    @BindView(R.id.coorad)
    CoordinatorLayout coorad;
    private ArrayList<DailyNewsBean.StoriesBean> newlist;
    private ArrayList<DailyNewsBean.TopStoriesBean> banners;
    private RlvDailyNewsAdapter adapter;
    private String mDate;
    private String data;

    @Override
    protected DailyNewsP initPresent() {
        return new DailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView() {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        newlist = new ArrayList<>();
        banners = new ArrayList<>();

        adapter = new RlvDailyNewsAdapter(getContext(), newlist, banners, data);
        re.setAdapter(adapter);
        dd.setOnClickListener(this);

    }


    @Override
    protected void initData() {
        present.getData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach:");
    }

    @Override
    public void setData(DailyNewsBean loginBean) {
        adapter.setData(loginBean);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), FloatActivity.class);
//        startActivity(intent);
        Snackbar.make(coorad, "这是一个snackbar", Snackbar.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getDate(String date) {
        mDate = date;
        Log.e("tag", "getDate: "+date );
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDate!=null){
            data=mDate;
            adapter.setmData(data);
            adapter.notifyDataSetChanged();
        }
    }
}
