package com.example.lenovo.mvp_cou.view;

import com.example.lenovo.mvp_cou.base.BaseActivity;
import com.example.lenovo.mvp_cou.base.BaseMvpView;

public interface LoginView extends BaseMvpView {

    void setData(String data);


    String getUserName();
    String getUserPwd();

    void showToast(String msg);

}
