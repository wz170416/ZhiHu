package com.example.lenovo.mvp_cou.net;

import com.example.lenovo.mvp_cou.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WechatServer {
    String wechat = "http://api.tianapi.com/";

    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeChatBean> wechatData();
}
