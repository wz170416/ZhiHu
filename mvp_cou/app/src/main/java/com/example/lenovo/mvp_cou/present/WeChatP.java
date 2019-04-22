package com.example.lenovo.mvp_cou.present;

import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.bean.WeChatBean;
import com.example.lenovo.mvp_cou.model.WechatM;
import com.example.lenovo.mvp_cou.view.WeChatV;

public class WeChatP extends BasePresenter<WeChatV> {

    private WechatM wechatM;

    @Override
    protected void initModel() {
        wechatM = new WechatM();
        mModels.add(wechatM);
    }

    public void getData() {
        wechatM.getData(new ResultCallBack<WeChatBean>() {
            @Override
            public void onSucces(WeChatBean loginBean) {
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
