package com.example.lenovo.mvp_cou.model;

import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.base.Constants;
import com.example.lenovo.mvp_cou.bean.LoginBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.net.ApiService;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginM extends BaseMode {

    public void login(String name, String pwd, final ResultCallBack callBack) {
        //进行网络请求
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {

                e.onNext("");
                e.onComplete();//完成的事件
            }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });







        final Observable<LoginBean> login = apiService.login(name, pwd);


        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        callBack.onSucces(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
