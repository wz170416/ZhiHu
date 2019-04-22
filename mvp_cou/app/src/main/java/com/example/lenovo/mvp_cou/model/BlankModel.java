package com.example.lenovo.mvp_cou.model;

import android.util.Log;


import com.example.lenovo.mvp_cou.base.BaseMode;
import com.example.lenovo.mvp_cou.bean.DocumentBean;
import com.example.lenovo.mvp_cou.net.ApiService;
import com.example.lenovo.mvp_cou.weight.ResultCallBack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class BlankModel extends BaseMode {
    private static final String TAG = "BlankModel";
    private DocumentBean documentBean;
    private ArrayList<DocumentBean> list = new ArrayList<>();;
    public void getBlank(final String href, final ResultCallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(ApiService.mUrl+href).get();
                    Elements items = document.select("div.cell.item");

                    for (Element itemElement : items) {
                        documentBean = new DocumentBean();
                        //查找图片
                        Elements images = itemElement.select("table tr td img.avatar");
                        if (images.size() > 0) {
                            //通过属性查找属性值
                            String icon = images.get(0).attr("src");
                            //Log.d(TAG, "icon: "+icon);
                            documentBean.setPic("https:"+icon);
                        }

                        //评论数量
                        Elements comments = itemElement.select("table tbody tr td a.count_livid");
                        if (comments.size() > 0) {
                            String text = comments.get(0).text();
                            //Log.d(TAG, "评论数量: "+text);
                            documentBean.setCount(text);
                        }

                        //标题
                        Elements titles = itemElement.select("table tr td span.item_title > a");
                        if (titles.size() > 0) {
                            String title = titles.get(0).text();
                            for (Element element:titles) {
                                String url = element.attr("href");
                                documentBean.setUrl(url);
                            }
                            //Log.d(TAG, "title: "+title);
                            documentBean.setTitle(title);
                        }

                        Elements times = itemElement.select("table tr td span.topic_info");
                        if (times.size() > 0) {
                            String text = times.get(0).text();
                            //Log.d(TAG, "time: " + text);
                            String[] split = text.split(" • ");
                            documentBean.setTab(split[0]);
                            documentBean.setAuthor(split[1]);
                            for (int i = 0; i < split.length; i++) {
                                if (i==2){
                                    if (split[2].length()>0) {
                                        documentBean.setTime(split[2]);
                                    }

                                }else if (i==3){
                                    if (split[3].length()>0) {
                                        documentBean.setLastPerson(split[3]);
                                    }
                                }
                            }

                        }
                        list.add(documentBean);
                    }
                    callBack.onSuccess(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
