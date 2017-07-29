package com.yiang.bar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;

import com.yiang.bar.R;
import com.yiang.bar.ToolBarManager;
import com.yiang.bar.annotation.InjectLayout;


/**
 * 1、注意在根布局中要加android:fitsSystemWindows="true",否则沉浸式不成功
 * 2、如果状态栏一开始设置白色，那么这边状态栏的字体还是没法显示
 * 3、
 */
@InjectLayout(layoutId = R.layout.ac_drawer)
public class DrawerLayoutActivity extends BaseActivity {

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, DrawerLayoutActivity.class);
        return intent;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ToolBarManager.with(this).setBackgroundColor(android.R.color.transparent).setTitle("标题");

//        //1、当设置有纯色的状态栏
//        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this, drawer, ContextCompat.getColor(this, R.color.white));
//        //2、设置有颜色有和默认透明度的状态栏
//        StatusBarUtil.setColorForDrawerLayout(this, drawer, ContextCompat.getColor(this, R.color.white));


//        //4、设置有默认透明度的状态栏
//        StatusBarUtil.setTranslucentForDrawerLayout(this, drawer);
//        //5、自定义透明度的状态栏，如果主布局的背景是白色，状态栏文字不可见
//        StatusBarUtil.setTranslucentForDrawerLayout(this, drawer, 0);
        //6、纯透明的状态栏，如果主布局的背景是白色，设置状态栏文字为黑色
//        StatusBarUtil.setTranslucentForDrawerLayout(this, drawer, true);


    }
}
