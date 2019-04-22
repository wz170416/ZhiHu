package com.example.lenovo.mvp_cou.bean;

import java.io.Serializable;

public class GoldBeans implements Serializable {
    public String title;
    public boolean isChecked;

    public GoldBeans(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }


}
