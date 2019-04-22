package com.example.lenovo.mvp_cou.view;

import android.support.v4.app.Fragment;


import com.example.lenovo.mvp_cou.base.BaseMvpView;

import java.util.ArrayList;
import java.util.List;

public interface V2EXView extends BaseMvpView {

    void setAllData(ArrayList<String> titles, ArrayList<Fragment> fragments);
}
