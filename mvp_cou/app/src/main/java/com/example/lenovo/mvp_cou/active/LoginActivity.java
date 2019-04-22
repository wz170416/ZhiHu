package com.example.lenovo.mvp_cou.active;
//张宝明
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.base.BaseActivity;
import com.example.lenovo.mvp_cou.present.LoginP;
import com.example.lenovo.mvp_cou.utils.ToastUtil;
import com.example.lenovo.mvp_cou.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/*
        MVP
        V:处理视图，用户交互
        P：业务逻辑，连接V和M层的桥梁
        M：处理数据：网络数据，数据库，io操作...耗时操作
 */
public class LoginActivity extends BaseActivity<LoginView,LoginP> implements LoginView {

    @BindView(R.id.btn)
    Button bt;
    @BindView(R.id.et_name)
    EditText name;
    @BindView(R.id.et_pwd)
    EditText pwd;

    @Override
    protected LoginP initPresenter() {
        return new LoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.btn})
    public void click(View bt) {
        //每次去转换类型，麻烦
      //  ((LoginP)presenter).getData();
      presenter.getData();
        presenter.login();

    }

    @Override
    public void setData(String data) {
        bt.setText(data);
    }

    @Override
    public String getUserName() {
        return name.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return pwd.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {

        //确保在主线程中调方法
        //Handler
        //runonUiThread
        ToastUtil.showShort(msg);
    }
}
