package com.example.lenovo.mvp_cou.present;

import android.support.v4.app.Fragment;


import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.model.V2EXModel;
import com.example.lenovo.mvp_cou.view.V2EXView;
import com.example.lenovo.mvp_cou.weight.MyCallBack;

import java.util.ArrayList;

public class V2EXPresenter extends BasePresenter<V2EXView> {

    private V2EXModel model;

    @Override
    protected void initModel() {
        model = new V2EXModel();
        mModels.add(model);
    }

    public void getV2EX() {
        model.getV2EX(new MyCallBack() {
            @Override
            public void onMySuccess(ArrayList<String> titles, ArrayList<Fragment> fragments) {
                mview.setAllData(titles,fragments);
            }
        });
    }

}
