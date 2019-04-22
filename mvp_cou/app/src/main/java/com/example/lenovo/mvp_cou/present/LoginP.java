package com.example.lenovo.mvp_cou.present;

import android.text.TextUtils;

import com.example.lenovo.mvp_cou.base.BasePresenter;
import com.example.lenovo.mvp_cou.bean.LoginBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.model.LoginM;
import com.example.lenovo.mvp_cou.utils.Logger;
import com.example.lenovo.mvp_cou.view.LoginView;

import static android.support.constraint.Constraints.TAG;


public class LoginP extends BasePresenter<LoginView> {

    private LoginM mainM;

    public void getData() {
        //获取数据
        String data = "网络回来的数据";
        if (mview != null) {
            //每次强制转换，麻烦
            //((LoginView)mview).setData(data);
            mview.setData(data);
        }
    }

    public void login() {
        String name = mview.getUserName();
        String pwd = mview.getUserPwd();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            mview.showToast("用户名或者密码不能为空");
            return;
        }

        //进行网络请求去登陆

        mainM.login(name, pwd, new ResultCallBack<LoginBean>() {
            @Override
            public void onSucces(LoginBean loginBean) {
                Logger.logD(TAG,loginBean.toString());
                //防止页面销毁，数据返回后设置页面的时空指针
                if (loginBean != null && loginBean.getCode() == 200 && mview != null) {

                    mview.showToast("登录成功");
                } else {
                    mview.showToast("登录失败");
                }
            }

            @Override
            public void onFails(String s) {
                Logger.logD(TAG, s);
                if (mview != null) {
                    mview.showToast("登录失败");
                }
            }
        });
    }

    @Override
    protected void initModel() {
        mainM = new LoginM();


    }
}
