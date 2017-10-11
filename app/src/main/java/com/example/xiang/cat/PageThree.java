package com.example.xiang.cat;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Xiang on 2017/9/1.
 */

public class PageThree extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.page_three, container, false);
        TextView txv3 =(TextView)view.findViewById(R.id.txv3);
        return  view;
    }
}
