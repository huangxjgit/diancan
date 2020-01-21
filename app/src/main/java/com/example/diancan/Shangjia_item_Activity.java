package com.example.diancan;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tandong.swichlayout.BaseEffects;
import com.tandong.swichlayout.SwichLayoutInterFace;
import com.tandong.swichlayout.SwitchLayout;

public class Shangjia_item_Activity extends AppCompatActivity implements SwichLayoutInterFace {

    public static final String SHANGJIA_NAME = "shangjia_name";
    public static final String SHANGJIA_IMAGE_ID = "shangjia_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangjia_item);

        Intent intent = getIntent();
        final String shangjiaName = intent.getStringExtra(SHANGJIA_NAME);
        int heroImageId = intent.getIntExtra(SHANGJIA_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tollbar);
        ImageView heroImageView = (ImageView) findViewById(R.id.hero_image_view);
        TextView heroContentText = (TextView) findViewById(R.id.website_item_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(shangjiaName);
        Glide.with(this).load(heroImageId).into(heroImageView);
        String heroContent = generateHeroContent(shangjiaName);
        heroContentText.setText(heroContent);
        setEnterSwichLayout();
    }



    private String generateHeroContent(String shangjiaName) {


        return "hello, world!";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setEnterSwichLayout() {
        SwitchLayout.getSlideFromTop(this, false,
                BaseEffects.getReScrollEffect());
    }

    @Override
    public void setExitSwichLayout() {
        SwitchLayout.getSlideToTop(this, true,
                BaseEffects.getReScrollEffect());
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {// 按返回键时退出Activity的Activity特效动画

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            setExitSwichLayout();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
