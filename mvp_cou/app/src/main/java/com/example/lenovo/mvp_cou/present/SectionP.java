package com.example.lenovo.mvp_cou.present;

import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.bean.ZhuangLang_Ribao;
import com.example.lenovo.mvp_cou.model.SectionM;
import com.example.lenovo.mvp_cou.view.SectionV;

public class SectionP extends BasePresenter<SectionV> {

    private SectionM sectionM;

    @Override
    protected void initModel() {
        sectionM = new SectionM();
        mModels.add(sectionM);
    }

    public void getData() {
        sectionM.getData(new ResultCallBack<ZhuangLang_Ribao>() {
            @Override
            public void onSucces(ZhuangLang_Ribao loginBean) {
                if (loginBean!= null){
                    if (mview!= null){
                        mview.setData(loginBean);
                    }
                }
            }

            @Override
            public void onFails(String s) {

            }
        });
    }
}
