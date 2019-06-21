package com.example.zuoye25;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zuoye25.adapter.VpAdapter;
import com.example.zuoye25.fragment.FragmentA;
import com.example.zuoye25.fragment.FragmentB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTl;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new FragmentA());
        mFragments.add(new FragmentB());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(vpAdapter);

        mTl.addTab(mTl.newTab().setText("首页"));
        mTl.addTab(mTl.newTab().setText("收藏"));

        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTl));
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTl = (TabLayout) findViewById(R.id.tl);
    }
}
