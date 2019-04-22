package com.example.lenovo.mvp_cou.bean;

import java.io.Serializable;

public class ItemBean implements Serializable{
    public String name;
    public boolean isSelect;

    public ItemBean(String name, boolean isSelect) {
        this.name = name;
        this.isSelect = isSelect;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "name='" + name + '\'' +
                ", isSelect=" + isSelect +
                '}';
    }
}
