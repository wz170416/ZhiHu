package com.example.lenovo.mvp_cou.bean;

public interface ResultCallBack<T> {
    void onSucces(T loginBean);
    void onFails(String s);


}
