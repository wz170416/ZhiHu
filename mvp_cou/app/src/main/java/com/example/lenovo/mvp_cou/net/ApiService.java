package com.example.lenovo.mvp_cou.net;

import com.example.lenovo.mvp_cou.bean.LoginBean;
import com.example.lenovo.mvp_cou.bean.V2EXBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    String sBaseUrl = "http://yun918.cn/study/public/index.php/";

    //登录
    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name,@Field("password") String pwd);


    String mUrl = "https://www.v2ex.com";
    String v2exUrl = "https://www.wanandroid.com/";

    @GET("navi/json")
    Observable<V2EXBean> getV2EXData();
}
