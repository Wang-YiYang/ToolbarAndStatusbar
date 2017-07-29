package com.yiang.bar.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yiang.bar.annotation.Yiang;


/**
 * Created by WYiang on 2017/7/28.
 */

public class BaseActivity extends AppCompatActivity {
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        Yiang.injectView(this, this);
        initView(savedInstanceState);
    }

    protected void initView(@Nullable Bundle savedInstanceState) {
    }
}
