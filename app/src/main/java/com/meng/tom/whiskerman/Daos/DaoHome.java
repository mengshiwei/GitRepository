package com.meng.tom.whiskerman.Daos;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.meng.tom.whiskerman.Fragments.AnimatorFragment;
import com.meng.tom.whiskerman.Fragments.MyviewFragment;
import com.meng.tom.whiskerman.Fragments.NetFragment;
import com.meng.tom.whiskerman.Fragments.PicxFragment;
import com.meng.tom.whiskerman.Fragments.ThirdFragment;
import com.meng.tom.whiskerman.R;

import java.util.ArrayList;
import java.util.List;

public class DaoHome {
    Context context;
    static DaoHome daoHome;

    public DaoHome(Context context) {
        this.context = context;
    }

    public static DaoHome getInstance(Context context) {
        if (daoHome == null) {
            daoHome = new DaoHome(context);
        }
        return daoHome;
    }

    public List<String> getTabs() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.tab_name_myview));
        list.add(context.getString(R.string.tab_name_picx));
        list.add(context.getString(R.string.tab_name_net));
        list.add(context.getString(R.string.tab_name_animator));
        list.add(context.getString(R.string.tab_name_third));
        return list;
    }

    /**
     * 获取主页面Fragments
     * @return
     */
    public List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList();
        list.add(MyviewFragment.newInstance("Myview", "Fragment"));
        list.add(PicxFragment.newInstance("Picx", "Fragment"));
        list.add(NetFragment.newInstance("Net", "Fragment"));
        list.add(AnimatorFragment.newInstance("Animator", "Fragment"));
        list.add(ThirdFragment.newInstance("Third", "Fragment"));
        return list;
    }

    public List<String> getImageUrls() {
        List<String> list = new ArrayList<>();
        list.add("http://img3.imgtn.bdimg.com/it/u=1809251218,717653159&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3225360273,3022566206&fm=27&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=1109001980,242658231&fm=200&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=749640632,266828823&fm=27&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=3695012849,2187312718&fm=27&gp=0.jpg");
        return list;
    }

    public List<String> getBannerTitles(){
        List<String> list=new ArrayList<>();
        list.add("标题一");
        list.add("标题二");
        list.add("标题三");
        list.add("标题四");
        list.add("标题五");
        return list;
    }
}