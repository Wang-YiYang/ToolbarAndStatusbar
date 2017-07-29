package com.yiang.bar.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yiang.bar.R;
import com.yiang.bar.annotation.InjectLayout;


@InjectLayout(layoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.button1://头部是图片的界面
                startActivity(ImageHeaderActivity.newInstance(context));
                break;

            case R.id.button2://头部是图片的界面
                startActivity(ImageFullActivity.newInstance(context));
                break;

            case R.id.button3:
                startActivity(NormalActivity.newInstance(context));
                break;

            case R.id.button4:
                startActivity(DrawerLayoutActivity.newInstance(context));
                break;


        }
    }
}
