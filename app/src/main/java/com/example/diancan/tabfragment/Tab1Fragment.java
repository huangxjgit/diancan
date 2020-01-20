package com.example.diancan.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.diancan.MyRefreshLottieHeader;
import com.example.diancan.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.File;

public class Tab1Fragment extends Fragment implements OnRefreshListener {
    SmartRefreshLayout mRefresh;
    View view;
    MyRefreshLottieHeader mRefreshLottieHeader;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab1, container, false);
        initView();
        doRun();
        return view;
    }

    private void initView(){
        mRefresh = view.findViewById(R.id.dindan_refresh);
        mRefreshLottieHeader = new MyRefreshLottieHeader(getActivity().getApplicationContext());
        mRefresh.setOnRefreshListener(this);
        mRefresh.setRefreshHeader(mRefreshLottieHeader);
    }

    private void doRun(){

    }

    public void onRefresh(RefreshLayout refreshlayout) {
        refreshlayout.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新事件
                mRefresh.finishRefresh();
            }
        },2000);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
