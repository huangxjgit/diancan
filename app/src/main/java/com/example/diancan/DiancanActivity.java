package com.example.diancan;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diancan.util.StatusBarUtil;


public class DiancanActivity extends AppCompatActivity {

    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;
    private BottomNavigationView bottomNavigationView;
    private ShouyeFragment shouyeFragment;
    private DindanFragment dindanFragment;
    private WodeFragment wodeFragment;
    private Fragment[] fragments;
    private int lastFragment; //用于记录上一个选择的碎片


    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false) {
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                        {
                            if(lastFragment!=0)
                            {
                                switchFragment(lastFragment,0);
                                lastFragment=0;
                            }

                            return true;
                        }

                        case R.id.navigation_dindan:
                        {
                            if(lastFragment!=1)
                            {
                                switchFragment(lastFragment,1);
                                lastFragment=1;

                            }

                            return true;
                        }

                        case R.id.navigation_wode:
                        {
                            if(lastFragment!=2)
                            {
                                switchFragment(lastFragment,2);
                                lastFragment=2;

                            }

                            return true;
                        }

                    }
                    return false;
                }
            };

    private void initFragment() {

        shouyeFragment = new ShouyeFragment();
        dindanFragment = new DindanFragment();
        wodeFragment = new WodeFragment();
        fragments = new Fragment[]{shouyeFragment,dindanFragment,wodeFragment};
        lastFragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,shouyeFragment).show(shouyeFragment).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diancan);
        initFragment();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

    }



    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
