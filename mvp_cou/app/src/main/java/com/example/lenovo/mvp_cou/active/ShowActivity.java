package com.example.lenovo.mvp_cou.active;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.RlvShowAdapter;
import com.example.lenovo.mvp_cou.base.BaseActivity;
import com.example.lenovo.mvp_cou.base.Constants;
import com.example.lenovo.mvp_cou.bean.GoldBeans;
import com.example.lenovo.mvp_cou.present.EmptyP;
import com.example.lenovo.mvp_cou.present.SimpleTouchHelperCallback;
import com.example.lenovo.mvp_cou.view.EmptyV;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV {

    @BindView(R.id.show_tb)
    Toolbar showTb;
    @BindView(R.id.show_recy)
    RecyclerView showRecy;
    private ArrayList<GoldBeans> list;

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        list = (ArrayList<GoldBeans>) getIntent().getSerializableExtra(Constants.DATA);

        showTb.setTitle(R.string.special_show);
        showTb.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(showTb);

        showTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finishAct();
            }
        });

        showRecy.setLayoutManager(new LinearLayoutManager(this));
        RlvShowAdapter adapter = new RlvShowAdapter(list);
        showRecy.setAdapter(adapter);
        showRecy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //拖拽移动和侧滑删除的功能
        SimpleTouchHelperCallback simple = new SimpleTouchHelperCallback(adapter);
        //拖拽是否滑动删除
        simple.setSwipEnable(false);
        ItemTouchHelper touchHelper = new ItemTouchHelper(simple);
        touchHelper.attachToRecyclerView(showRecy);



    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA,list);
        setResult(RESULT_OK,intent);
        finish();
    }
}
