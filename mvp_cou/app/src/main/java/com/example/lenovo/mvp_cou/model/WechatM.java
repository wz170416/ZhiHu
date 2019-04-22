package com.example.lenovo.mvp_cou.model;

import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.bean.WeChatBean;
import com.example.lenovo.mvp_cou.net.BaseObserver;
import com.example.lenovo.mvp_cou.net.HttpUtils;
import com.example.lenovo.mvp_cou.net.RxUtils;
import com.example.lenovo.mvp_cou.net.WechatServer;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WechatM extends BaseMode {
    public void getData(final ResultCallBack<WeChatBean> weChatBeanResultCallBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WechatServer.wechat)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        WechatServer server = retrofit.create(WechatServer.class);
        Observable<WeChatBean> wechat = server.wechatData();
        wechat.compose(RxUtils.<WeChatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        weChatBeanResultCallBack.onSucces(weChatBean);
                    }
                });
    }
}
