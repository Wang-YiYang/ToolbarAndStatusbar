package com.yiang.bar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.yiang.bar.R;
import com.yiang.bar.annotation.InjectLayout;
import com.yiang.bar.ui.fragment.ToolbarTestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WYiang on 2017/8/10.
 */
@InjectLayout(layoutId = R.layout.ac_pager)
public class PagerActivity extends BaseActivity {

    private List<Fragment> fragments;

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, PagerActivity.class);
        return intent;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {


        fragments = new ArrayList<>();
        fragments.add(ToolbarTestFragment.newInstance());

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
