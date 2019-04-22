package com.example.lenovo.mvp_cou.model;

import android.support.v4.app.Fragment;


import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.fragment.BlankFragment;
import com.example.lenovo.mvp_cou.weight.MyCallBack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class V2EXModel extends BaseMode {
    private String mUrl = "https://www.v2ex.com/";
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;


    public void getV2EX(final MyCallBack callBack) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    titles = new ArrayList<>();
                    fragments = new ArrayList<>();
                    Document document = Jsoup.connect(mUrl).get();
                    if (document != null) {
                        Elements tabs = document.select("div#Tabs.inner > a");
                        for (Element element : tabs) {
                            String text = element.text();
                            String href = element.attr("href");
                            //Log.d(TAG, "tab: "+text+",href:"+href);
                            titles.add(text);
                            fragments.add(BlankFragment.newInstant(href));
                        }

                        callBack.onMySuccess(titles,fragments);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
