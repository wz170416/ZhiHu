package com.example.lenovo.mvp_cou.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMode {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void onDestory() {
        mCompositeDisposable.clear();
    }
}
