package com.example.lenovo.mvp_cou.present;


import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.DocumentBean;
import com.example.lenovo.mvp_cou.model.BlankModel;
import com.example.lenovo.mvp_cou.view.BlankView;
import com.example.lenovo.mvp_cou.weight.ResultCallBack;

import java.util.ArrayList;

public class BlankPresenter extends BasePresenter<BlankView> {

    private BlankModel model;

    @Override
    protected void initModel() {
        model = new BlankModel();
        mModels.add(model);
    }
    public void getBlank(String href) {
        model.getBlank(href,new ResultCallBack<ArrayList<DocumentBean>>() {
            @Override
            public void onSuccess(ArrayList<DocumentBean> bean) {
                mview.updateDoc(bean);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}
