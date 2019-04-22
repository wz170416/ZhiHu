package com.example.lenovo.mvp_cou.active;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.adapter.NodeAd;
import com.example.lenovo.mvp_cou.base.BaseActivity;
import com.example.lenovo.mvp_cou.bean.V2EXBean;
import com.example.lenovo.mvp_cou.present.NodePresenter;
import com.example.lenovo.mvp_cou.view.NodeView;

import java.util.ArrayList;
import java.util.List;
//张宝明
import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;

public class NodeNaviActivity extends BaseActivity<NodeView, NodePresenter> implements NodeView {

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private NodeAd nodeAd;


    @Override
    protected NodePresenter initPresenter() {
        return new NodePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_node_navi;
    }

    @Override
    protected void initView() {
        mToolbar.setTitle("节点导航");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<V2EXBean.DataBean> list = new ArrayList<>();
        nodeAd = new NodeAd(this, list);
        mRlv.setAdapter(nodeAd);
    }

    @Override
    protected void initData() {
        presenter.getNode();
    }

    @Override
    public void updateNode(final List<V2EXBean.DataBean> data) {
        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return data.get(i).getName();
            }
        };
        mRlv.addItemDecoration(normalDecoration);
        nodeAd.setAll(data);

    }

}
