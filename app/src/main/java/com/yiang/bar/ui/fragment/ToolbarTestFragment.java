package com.yiang.bar.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yiang.bar.R;
import com.yiang.bar.ToolBarManager;

/**
 * Created by WYiang on 2017/8/10.
 */

public class ToolbarTestFragment extends Fragment {

    public static ToolbarTestFragment newInstance() {
        ToolbarTestFragment instance = new ToolbarTestFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        ToolBarManager.with(getActivity(), v).setTitle("hah");


        return v;
    }
}
