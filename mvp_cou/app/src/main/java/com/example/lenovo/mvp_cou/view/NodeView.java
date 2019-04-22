package com.example.lenovo.mvp_cou.view;



import com.example.lenovo.mvp_cou.base.BaseMvpView;
import com.example.lenovo.mvp_cou.bean.V2EXBean;

import java.util.List;

public interface NodeView extends BaseMvpView {
    void updateNode(List<V2EXBean.DataBean> data);
}
