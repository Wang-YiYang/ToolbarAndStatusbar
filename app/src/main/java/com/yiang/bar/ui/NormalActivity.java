package com.yiang.bar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.yiang.bar.R;
import com.yiang.bar.ToolBarManager;
import com.yiang.bar.annotation.InjectLayout;
import com.yiang.bar.utils.StatusBarUtil;


/**
 * Created by WYiang on 2017/7/28.
 */
@InjectLayout(layoutId = R.layout.ac_normal)
public class NormalActivity extends BaseActivity {
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, NormalActivity.class);
        return intent;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        ToolBarManager.with(this).setTitle("标题", R.color.colorAccent).setBackgroundColor(R.color.white);

        //状态栏纯色背景
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.
        white),0);
    }
}
