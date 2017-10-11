package com.example.xiang.cat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Xiang on 2017/9/1.
 */

public class PageOne extends Fragment {
    private TabLayout mTablayout;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments= new ArrayList<Fragment>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.page_one, container, false);
        mTablayout = (TabLayout)view.findViewById(R.id.tabs);
        initView();
        //mTablayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener)this);
        return  view;

    }
    private void initView() {
        PageToday pt = new PageToday();
        PagePopular pp = new PagePopular();

        mFragments.add(pt);
        mFragments.add(pp);

        mTablayout.addTab(mTablayout.newTab().setText("本日活動"));

        mTablayout.addTab(mTablayout.newTab().setText("熱門活動"));
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}