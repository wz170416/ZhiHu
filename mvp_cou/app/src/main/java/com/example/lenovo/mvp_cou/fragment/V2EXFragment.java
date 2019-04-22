package com.example.lenovo.mvp_cou.fragment;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;


import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.active.NodeNaviActivity;
import com.example.lenovo.mvp_cou.base.BaseFragment;
import com.example.lenovo.mvp_cou.base.BaseMvpView;
import com.example.lenovo.mvp_cou.present.V2EXPresenter;
import com.example.lenovo.mvp_cou.view.V2EXView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2EXFragment extends BaseFragment<V2EXView, V2EXPresenter> implements V2EXView {

    @BindView(R.id.gold_tab)
    TabLayout mTab;
    @BindView(R.id.gold_iv)
    ImageView mArrow;
    @BindView(R.id.gold_vp)
    ViewPager mVp;
    private static final String TAG = "V2EXFragment";

    public V2EXFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @OnClick({R.id.gold_iv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gold_iv:
                goToShow();
                break;
        }
    }

    @Override
    protected void initData() {
        present.getV2EX();
    }

    @Override
    protected V2EXPresenter initPresent() {
        return new V2EXPresenter();
    }



    private void goToShow() {
        startActivity(new Intent(getContext(), NodeNaviActivity.class));
    }

    @Override
    public void setAllData( final ArrayList<String> titles, final ArrayList<Fragment> fragments) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public int getCount() {
                        return fragments.size();
                    }

                    @Override
                    public Fragment getItem(int i) {
                        return fragments.get(i);
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return titles.get(position);
                    }
                };
                mVp.setAdapter(adapter);
                mTab.setupWithViewPager(mVp);
            }
        });

    }

}
