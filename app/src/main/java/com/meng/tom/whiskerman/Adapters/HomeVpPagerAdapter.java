package com.meng.tom.whiskerman.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

public class HomeVpPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fraglist;
    FragmentManager fm;
    List<String> tabTitleList;

    public HomeVpPagerAdapter(FragmentManager fm, List<Fragment> fraglist, List<String> tabTitleList) {
        super(fm);
        this.fm = fm;
        this.fraglist = fraglist;
        this.tabTitleList = tabTitleList;
    }


    @Override
    public Fragment getItem(int position) {
        return fraglist.get(position);
    }

    @Override
    public int getCount() {
        return fraglist.size();
    }
    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitleList.get(position % tabTitleList.size());
    }
}