package com.example.lenovo.mvp_cou.net;

import com.example.lenovo.mvp_cou.bean.DailyNewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ZhihuServer {
    String sBaseUrl = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyNewsBean> getLastDailyNews();

}
