package com.example.lenovo.mvp_cou.model;

import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.ResultCallBack;
import com.example.lenovo.mvp_cou.bean.ZhuangLang_Ribao;
import com.example.lenovo.mvp_cou.net.BaseObserver;
import com.example.lenovo.mvp_cou.net.HttpUtils;
import com.example.lenovo.mvp_cou.net.RiBaoServer;
import com.example.lenovo.mvp_cou.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SectionM extends BaseMode {
    public void getData(final ResultCallBack<ZhuangLang_Ribao> resultCallBack) {
        RiBaoServer apiserver = HttpUtils.getInstance().getApiserver(RiBaoServer.ribao, RiBaoServer.class);
        Observable<ZhuangLang_Ribao> ribaoData = apiserver.ribaoData();
        ribaoData.compose(RxUtils.<ZhuangLang_Ribao>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhuangLang_Ribao>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhuangLang_Ribao zhuangLang_ribao) {
                        resultCallBack.onSucces(zhuangLang_ribao);
                    }
                });
    }
}
