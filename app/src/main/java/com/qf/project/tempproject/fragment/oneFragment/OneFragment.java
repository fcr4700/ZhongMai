package com.qf.project.tempproject.fragment.oneFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.project.tempproject.R;
import com.qf.project.tempproject.adapter.OneViewPagerAdapter;
import com.qf.project.tempproject.fragment.oneFragment.fcrFragment.fcrOneFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8 0008.
 */
public class OneFragment extends Fragment{

    TabLayout mTab;
    List<ImageView> mList;
    List<Fragment> fragmentList;
    List<String> titleList;
    ViewPager mViewPager;
    OneViewPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTab= (TabLayout) view.findViewById(R.id.onefragment_hsv);
        mViewPager= (ViewPager) view.findViewById(R.id.onefragment_vp);

        initmTab();
        adapter=new OneViewPagerAdapter(getFragmentManager(),titleList,fragmentList);
        mViewPager.setAdapter(adapter);
    }

    private void initmTab() {
        mList=new ArrayList<>();

        fragmentList=new ArrayList<>();
        fragmentList.add(new fcrOneFragment().getInstance("REMEN"));
        fragmentList.add(new fcrOneFragment().getInstance("JINGCAI"));
        fragmentList.add(new fcrOneFragment().getInstance("ZOUJING"));
        fragmentList.add(new fcrOneFragment().getInstance("SHENGTAI"));
        fragmentList.add(new fcrOneFragment().getInstance("PINGPAI"));
        fragmentList.add(new fcrOneFragment().getInstance("HUIHUANG"));
        fragmentList.add(new fcrOneFragment().getInstance("BINGFENG"));




        /*ImageView aImg=new ImageView(getActivity());
        ImageView bImg=new ImageView(getActivity());
        ImageView cImg=new ImageView(getActivity());
        ImageView dImg=new ImageView(getActivity());
        ImageView eImg=new ImageView(getActivity());
        ImageView fImg=new ImageView(getActivity());
        ImageView gImg=new ImageView(getActivity());
        ImageView hImg=new ImageView(getActivity());

        aImg.setImageResource(R.drawable.a);
        bImg.setImageResource(R.drawable.b);
        cImg.setImageResource(R.drawable.c);
        dImg.setImageResource(R.drawable.d);
        eImg.setImageResource(R.drawable.a);
        fImg.setImageResource(R.drawable.b);
        gImg.setImageResource(R.drawable.c);
        hImg.setImageResource(R.drawable.d);

        mList.add(aImg);
        mList.add(bImg);
        mList.add(cImg);
        mList.add(dImg);
        mList.add(eImg);
        mList.add(fImg);
        mList.add(gImg);
        mList.add(hImg);*/

        titleList=new ArrayList<>();
        titleList.add("热门推荐");
        titleList.add("精彩专题");
        titleList.add("走进中脉");
        titleList.add("生态家");
        titleList.add("品牌活动");
        titleList.add("辉煌盛典");
        titleList.add("缤纷旅程");


        for (int i = 0; i < titleList.size(); i++) {
            mTab.addTab(mTab.newTab().setText(titleList.get(i)));
        }

        mTab.setupWithViewPager(mViewPager);




    }


}