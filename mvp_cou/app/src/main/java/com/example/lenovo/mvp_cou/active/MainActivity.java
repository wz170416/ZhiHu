package com.example.lenovo.mvp_cou.active;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.mvp_cou.R;
import com.example.lenovo.mvp_cou.base.BaseActivity;
import com.example.lenovo.mvp_cou.fragment.AboutFragmet;
import com.example.lenovo.mvp_cou.fragment.CollectFragment;
import com.example.lenovo.mvp_cou.fragment.GankFragment;
import com.example.lenovo.mvp_cou.fragment.GoldFragment;
import com.example.lenovo.mvp_cou.fragment.SettingFragment;
import com.example.lenovo.mvp_cou.fragment.V2EXFragment;
import com.example.lenovo.mvp_cou.fragment.WechatFragment;
import com.example.lenovo.mvp_cou.fragment.ZhuhuFragment;
import com.example.lenovo.mvp_cou.present.MainP;
import com.example.lenovo.mvp_cou.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainView, MainP> implements MainView {


    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.fram)
    FrameLayout fram;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.search_view)
    MaterialSearchView sear;


    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    private ArrayList<Integer> title;

    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTINGS = 6;
    private final int TYPE_ABOUT = 7;
    private int mlastfragmentPosition;
    private MenuItem searchitem;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        tb.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(tb);

        ActionBarDrawerToggle action = new ActionBarDrawerToggle(this, dl, tb, R.string.about, R.string.about);
        action.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(action);
        action.syncState();

        initFragments();
        initTitles();
        addZhihuDFragment();

//       sear.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
       // sear.setVisibility(View.GONE);
    }

    private void addZhihuDFragment() {
        FragmentTransaction beain = manager.beginTransaction();
        beain.add(R.id.fram, fragments.get(0));
        beain.commit();

        tb.setTitle(title.get(0));
    }

    private void initTitles() {
        title = new ArrayList<>();
        title.add(R.id.zhihu);
        title.add(R.id.wechat);
        title.add(R.id.gank);
        title.add(R.id.gold);
        title.add(R.id.v2ex);
        title.add(R.id.collect);
        title.add(R.id.settings);
        title.add(R.id.about);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new ZhuhuFragment());
        fragments.add(new WechatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2EXFragment());
        fragments.add(new CollectFragment());
        fragments.add(new SettingFragment());
        fragments.add(new AboutFragmet());
    }

    @Override
    protected void initListenter() {
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.option_group) {
                    item.setChecked(true);

                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            break;
                        case R.id.v2ex:
                            switchFragment(TYPE_V2EX);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COLLECT);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTINGS);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            break;
                    }
                    dl.closeDrawer(Gravity.LEFT);
                } else {
                    item.setChecked(false);
                }
                return false;
            }
        });
        sear.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //按下搜索或者提交的时候回调,
                //ToastUtil.showShort("提交的内容:"+query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索框内容发生改变的回调,
                //ToastUtil.showShort(newText);
                return false;
            }
        });


        sear.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展示
                //ToastUtil.showShort("展示");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框隐藏
                //ToastUtil.showShort("关闭");
            }
        });

    }

    private void switchFragment(int type) {
        Fragment fragment = fragments.get(type);
        Fragment hidefragment = fragments.get(mlastfragmentPosition);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fram, fragment);
        }
        transaction.show(fragment);
        transaction.hide(hidefragment);
        transaction.commit();
        mlastfragmentPosition = type;


        //显示或者隐藏搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            searchitem.setVisible(true);
        }else {
            searchitem.setVisible(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        searchitem = menu.findItem(R.id.action);
        searchitem.setVisible(false);
        sear.setMenuItem(searchitem);
        return true;
    }
    /**
     * 回退键点击回调
     */
    @Override
    public void onBackPressed() {
        if (sear.isSearchOpen()) {
            sear.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

}
