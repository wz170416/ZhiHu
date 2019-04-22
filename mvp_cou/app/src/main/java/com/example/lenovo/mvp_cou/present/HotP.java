package com.example.lenovo.mvp_cou.present;

import com.example.lenovo.mvp_cou.base.BaseMvpView;
import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.HotBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.model.HotM;
import com.example.lenovo.mvp_cou.view.HotV;

public class HotP extends BasePresenter<HotV> {

    private HotM hotM;

    @Override
    protected void initModel() {
        hotM = new HotM();
        mModels.add(hotM);
    }

    public void getData() {
      hotM.getData(new ResultCallBack<HotBean>() {
          @Override
          public void onSucces(HotBean loginBean) {
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
