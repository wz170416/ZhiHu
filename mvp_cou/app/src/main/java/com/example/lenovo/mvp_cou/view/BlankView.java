package com.example.lenovo.mvp_cou.view;


import com.example.lenovo.mvp_cou.base.BaseMvpView;
import com.example.lenovo.mvp_cou.bean.DocumentBean;

import java.util.ArrayList;

public interface BlankView extends BaseMvpView {
    void updateDoc(ArrayList<DocumentBean> bean);
}
