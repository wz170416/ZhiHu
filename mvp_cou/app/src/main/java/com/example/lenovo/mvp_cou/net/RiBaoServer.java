package com.example.lenovo.mvp_cou.net;

import com.example.lenovo.mvp_cou.bean.HotBean;
import com.example.lenovo.mvp_cou.bean.ZhuangLang_Ribao;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RiBaoServer {
    String ribao = "http://news-at.zhihu.com/api/ ";

    @GET("4/sections")
    Observable<ZhuangLang_Ribao> ribaoData();

}
