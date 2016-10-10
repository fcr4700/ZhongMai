package com.qf.project.tempproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class OneViewPagerAdapter extends FragmentStatePagerAdapter{
    List<ImageView> mList;
    List<String> titleList;
    List<Fragment> fragmentList;

    public OneViewPagerAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
