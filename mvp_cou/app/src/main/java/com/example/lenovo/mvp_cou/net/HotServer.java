package com.example.lenovo.mvp_cou.net;

import com.example.lenovo.mvp_cou.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HotServer {
    String da = "http://news-at.zhihu.com/api/4/ ";

    @GET("news/hot")
    Observable<HotBean> hotData();
}
