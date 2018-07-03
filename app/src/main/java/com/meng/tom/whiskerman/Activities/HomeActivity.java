package com.meng.tom.whiskerman.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View;
import android.view.Window;

import com.meng.tom.whiskerman.Adapters.HomeVpPagerAdapter;
import com.meng.tom.whiskerman.Daos.DaoHome;
import com.meng.tom.whiskerman.R;

import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private ViewPager vpHome;
    private TabLayout tabHome;
    private List<String> tabStringList;
    private List<Fragment> fragmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为是继承的appcompatActivity所以此行代码无效
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        //改为
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        tabHome = (TabLayout) findViewById(R.id.tab_home);
        vpHome = (ViewPager) findViewById(R.id.vp_home);

        tabStringList = DaoHome.getInstance(this).getTabs();
        fragmentsList = DaoHome.getInstance(this).getFragments();

        tabHome.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabHome.addTab(tabHome.newTab().setText(tabStringList.get(0)));
        tabHome.addTab(tabHome.newTab().setText(tabStringList.get(1)));
        tabHome.addTab(tabHome.newTab().setText(tabStringList.get(2)));
        tabHome.addTab(tabHome.newTab().setText(tabStringList.get(3)));
        tabHome.addTab(tabHome.newTab().setText(tabStringList.get(4)));

        vpHome.setAdapter(new HomeVpPagerAdapter(getSupportFragmentManager(),fragmentsList,tabStringList));
        vpHome.setOffscreenPageLimit(5);//x代表Fragment数量
        tabHome.setupWithViewPager(vpHome);

    }
}
