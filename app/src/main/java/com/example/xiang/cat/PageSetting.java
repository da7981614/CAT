package com.example.xiang.cat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Xiang on 2017/9/29.
 */

public class PageSetting extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_setting, container, false);
        TextView txv2 = (TextView) view.findViewById(R.id.txv2);
        return view;
    }
}