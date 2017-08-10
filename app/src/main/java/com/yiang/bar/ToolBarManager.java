package com.yiang.bar;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


/**
 * Created by WYiang on 2017/7/28.
 */

public class ToolBarManager {

    private static final String TAG = "ToolBarManager";
    private final View mContent;
    private Toolbar toolbar;
    private AppCompatActivity activity;

    private TextView tvTitle;//标题

    /**
     * activity中使用
     *
     * @param activity
     */
    private ToolBarManager(AppCompatActivity activity) {
        this.activity = activity;
        //获取界面内容视图
        mContent = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        initToolbar();
    }

    /**
     * 在fragment中使用
     *
     * @param activity fragment所在界面
     * @param view     fragment的视图
     * @return
     */
    private ToolBarManager(AppCompatActivity activity, View view) {
        this.activity = activity;
        //获取界面内容视图
        mContent = view;
        initToolbar();
    }

    /**
     * 时间：2017/7/28
     * 描述:初始化
     */
    private void initToolbar() {
        toolbar = (Toolbar) mContent.findViewById(R.id.id_toolbar);
        if (toolbar == null) {
            throw new NullPointerException("toolbar对象为空，请查看界面布局中是否引用layout_toolbar");
        }
        tvTitle = (TextView) toolbar.findViewById(R.id.toolbar_tv_title);

        //setup
        //setup
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("");//不显示toolbar自带的图标
        actionBar.setDisplayHomeAsUpEnabled(false);
        setNavigationIcon(0);//默认不显示返回图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        toolbar.setNavigationIcon(null);
    }

    /**
     * activity中使用
     *
     * @param activity
     * @return
     */
    public static ToolBarManager with(AppCompatActivity activity) {
        return new ToolBarManager(activity);
    }

    /**
     * 在fragment中使用
     *
     * @param activity fragment所在界面
     * @param view     fragment的视图
     * @return
     */
    public static ToolBarManager with(FragmentActivity activity, View view) {
        return new ToolBarManager((AppCompatActivity) activity, view);
    }

    /**
     * 时间：2017/7/28
     * 描述:设置toolbar的背景颜色
     */
    public ToolBarManager setBackgroundColor(@ColorRes int color) {
        toolbar.setBackgroundColor(ContextCompat.getColor(activity, color));
        return this;

    }

    /**
     * 时间：2017/7/28
     * 描述:设置toolbar左边的返回按钮，输入0标识不显示图标
     */
    public ToolBarManager setNavigationIcon(@DrawableRes int resId) {
        if (resId != 0) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(resId);
        } else {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        return this;
    }

    /**
     * 时间：2017/7/28
     * 描述:设置标题内容，默认白色字体
     */
    public ToolBarManager setTitle(CharSequence title) {
        return setTitle(title, R.color.white);
    }

    /**
     * 时间：2017/7/28
     * 描述:设置标题内容和字体颜色
     */
    public ToolBarManager setTitle(CharSequence title, @ColorRes int color) {
        tvTitle.setText(title);
        tvTitle.setTextColor(ContextCompat.getColor(activity, color));
        return this;
    }


}
