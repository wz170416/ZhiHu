package com.example.lenovo.mvp_cou.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseMvpView,P extends BasePresenter>
        extends Fragment implements BaseMvpView{

    protected Unbinder unbinder;
    public P present;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
        present = initPresent();
        if (present != null){
            present.bind((V)this);
        }
        initView();
        initListentr();
        initData();
        return inflate;
    }

    protected  void initData(){

    }

    protected  void initListentr(){

    }

    protected  void initView(){

    }

    protected abstract P initPresent();

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}
