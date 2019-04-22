package com.example.lenovo.mvp_cou.model;


import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.V2EXBean;
import com.example.lenovo.mvp_cou.net.ApiService;
import com.example.lenovo.mvp_cou.net.BaseObserver;
import com.example.lenovo.mvp_cou.net.HttpUtils;
import com.example.lenovo.mvp_cou.net.RxUtils;
import com.example.lenovo.mvp_cou.weight.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class NodeModel extends BaseMode {
    public void getNode(final ResultCallBack callBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.v2exUrl, ApiService.class);
        Observable<V2EXBean> observable = apiserver.getV2EXData();
        observable.compose(RxUtils.<V2EXBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<V2EXBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(V2EXBean v2EXBean) {
                        if (v2EXBean.getErrorCode()==0){
                            callBack.onSuccess(v2EXBean);
                        }else {
                            callBack.onFailed("请求失败");
                        }
                    }
                });
    }
}
