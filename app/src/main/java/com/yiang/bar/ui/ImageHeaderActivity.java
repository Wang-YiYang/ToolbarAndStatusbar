package com.yiang.bar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yiang.bar.R;
import com.yiang.bar.ToolBarManager;
import com.yiang.bar.annotation.InjectLayout;
import com.yiang.bar.utils.StatusBarUtil;


/**
 *
 * 使用浸入式是全屏的，状态栏与当前页面重叠,
 * 1、如果没有包含toolbar那么就不需要设置下移的视图， StatusBarUtil.setTranslucentForImageView(this,null);
 * 2、如果包含了toolbar，根布局最好使用【相对布局】或者【帧布局】:
 *    注意要下移的视图是toolbar，而不是布局的根视图，如果设置下移根视图那么状态拦背景变成黑色
 *    正确的是使用StatusBarUtil.setTranslucentForImageView(this,toolbar视图);
 * 3、设置图片的控件不一定非要用imageview,可以是整个布局浸入
 */
@InjectLayout(layoutId = R.layout.ac_imageheader)
public class ImageHeaderActivity extends BaseActivity {


    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, ImageHeaderActivity.class);
        return intent;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        //头部图片沉浸式
        StatusBarUtil.setTranslucentForImageView(this,0, findViewById(R.id.id_toolbar));
        ToolBarManager.with(this)
                .setBackgroundColor(android.R.color.transparent)
                .setNavigationIcon(R.mipmap.ic_launcher)
                .setTitle("hah");
    }
}
