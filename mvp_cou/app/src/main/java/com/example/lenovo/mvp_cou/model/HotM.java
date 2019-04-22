package com.example.lenovo.mvp_cou.model;

import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.HotBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.net.BaseObserver;
import com.example.lenovo.mvp_cou.net.HotServer;
import com.example.lenovo.mvp_cou.net.RiBaoServer;
import com.example.lenovo.mvp_cou.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotM extends BaseMode {

    public void getData(final ResultCallBack<HotBean> resultCallBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HotServer.da)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HotServer hotServer = retrofit.create(HotServer.class);
        Observable<HotBean> hot = hotServer.hotData();
        hot.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        resultCallBack.onSucces(hotBean);
                    }
                });
    }
}
