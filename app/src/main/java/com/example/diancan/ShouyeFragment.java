package com.example.diancan;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import java.util.ArrayList;
import java.util.List;


public class ShouyeFragment extends Fragment {
    private BaiduMap baiduMap;
    private View view;
    private MapView mapView = null;
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefresh;

    private Shangjia[]shangjias={new Shangjia("德德塔炸鸡汉堡",R.drawable.bhanbao),new Shangjia("有一家海鲜焖面",R.drawable.bhuajia),
            new Shangjia("黄金炒饭",R.drawable.bchaofan),
            new Shangjia("满口香卤肉饭",R.drawable.bluroufan),new Shangjia("特价鸡排饭",R.drawable.bjipaifan),
            new Shangjia("五通正宗钵钵鸡",R.drawable.bboboji)};
    private List<Shangjia> shangjiaList=new ArrayList<>();
    private ShangjiaAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shouye, container, false);
        mapView = (MapView) view.findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);

        searchView = (SearchView) view.findViewById(R.id.serachview);
        //设置查询提示字符串
        searchView.setQueryHint("请输入搜索内容");
        //设置搜索图标是否显示在搜索框内
        searchView.setIconifiedByDefault(false);
        initShangjias();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ShangjiaAdapter(shangjiaList);
        recyclerView.setAdapter(adapter);

        swipeRefresh=(SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });
        return view;
    }

    private void initShangjias(){
        shangjiaList.clear();
        for (int i=0;i<shangjias.length;i++){
            shangjiaList.add(shangjias[i]);
        }
    }

    private void refreshItem(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

}
