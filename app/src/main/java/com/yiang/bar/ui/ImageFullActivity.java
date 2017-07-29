package com.yiang.bar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yiang.bar.R;
import com.yiang.bar.annotation.InjectLayout;
import com.yiang.bar.utils.StatusBarUtil;


/**
 * Created by WYiang on 2017/7/28.
 */
@InjectLayout(layoutId = R.layout.ac_image_full)
public class ImageFullActivity extends BaseActivity {
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, ImageFullActivity.class);
        return intent;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
//        //1、默认透明度状态栏
//        StatusBarUtil.setTranslucentForImageView(this, null);//有一定透明度
//        //2、纯色状态栏
//        StatusBarUtil.setTranslucentForImageView(this,0, null);//纯色状态栏

        //3、纯色状态栏
        StatusBarUtil.setTranslucent(this);
    }
}
