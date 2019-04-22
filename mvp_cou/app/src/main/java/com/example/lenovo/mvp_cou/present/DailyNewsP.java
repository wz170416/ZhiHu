package com.example.lenovo.mvp_cou.present;

import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.DailyNewsBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.model.DailyNewsM;
import com.example.lenovo.mvp_cou.view.DailyNewsV;

public class DailyNewsP extends BasePresenter<DailyNewsV> {

    private DailyNewsM dailyNewsM;

    @Override
    protected void initModel() {
        dailyNewsM = new DailyNewsM();
        mModels.add(dailyNewsM);

    }

    public void getData() {
        dailyNewsM.getData(new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSucces(DailyNewsBean loginBean) {
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
