package com.example.lenovo.mvp_cou.present;


import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.V2EXBean;
import com.example.lenovo.mvp_cou.model.NodeModel;
import com.example.lenovo.mvp_cou.utils.ToastUtil;
import com.example.lenovo.mvp_cou.view.NodeView;
import com.example.lenovo.mvp_cou.weight.ResultCallBack;

public class NodePresenter extends BasePresenter<NodeView> {

    private NodeModel model;

    @Override
    protected void initModel() {
        model = new NodeModel();
        mModels.add(model);
    }

    public void getNode() {
        model.getNode(new ResultCallBack<V2EXBean>() {
            @Override
            public void onSuccess(V2EXBean bean) {
                if (bean!=null&&bean.getData().size()>0){
                    mview.updateNode(bean.getData());
                }
            }

            @Override
            public void onFailed(String msg) {
                ToastUtil.showLong(msg);
            }
        });
    }
}
