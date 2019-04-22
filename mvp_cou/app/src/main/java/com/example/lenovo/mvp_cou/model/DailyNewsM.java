package com.example.lenovo.mvp_cou.model;

import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.DailyNewsBean;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.net.BaseObserver;
import com.example.lenovo.mvp_cou.net.HttpUtils;
import com.example.lenovo.mvp_cou.net.RxUtils;
import com.example.lenovo.mvp_cou.net.ZhihuServer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;

public class DailyNewsM extends BaseMode {
    public void getData(final ResultCallBack<DailyNewsBean> resultCallBack) {
        ZhihuServer apiserver = HttpUtils.getInstance().getApiserver(ZhihuServer.sBaseUrl, ZhihuServer.class);
        Observable<DailyNewsBean> dailyNews = apiserver.getLastDailyNews();
        dailyNews.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        resultCallBack.onSucces(dailyNewsBean);
                    }
                });
    }
}
