package com.example.lenovo.mvp_cou.weight;

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFailed(String msg);


}
