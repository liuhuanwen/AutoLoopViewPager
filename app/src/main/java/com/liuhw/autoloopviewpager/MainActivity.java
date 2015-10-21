package com.liuhw.autoloopviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.liuhw.autoloopviewpager.adapter.BannerAdapter;
import com.liuhw.autoloopviewpager.pagerindicator.AutoLoopViewPager;
import com.liuhw.autoloopviewpager.pagerindicator.CirclePageIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AutoLoopViewPager bannerViewPager;
    private CirclePageIndicator circlePagerIndicator;
    private ArrayList<Integer> imageIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initData();
        initAutoLoopViewPager();
        initCirclePageIndicator();

    }

    private void initCirclePageIndicator() {
        circlePagerIndicator = (CirclePageIndicator) findViewById(R.id.circlePagerIndicator);
        circlePagerIndicator.setViewPager(bannerViewPager);
    }

    private void initAutoLoopViewPager() {
        bannerViewPager = (AutoLoopViewPager) findViewById(R.id.bannerViewPager);
        // viewpager中边界的view不销毁,防止在轮播时闪屏
        bannerViewPager.setBoundaryCaching(true);
        // 是否自动滚动,默认true
        bannerViewPager.setCycle(true);
        // 设置滚动方向,默认向右
        bannerViewPager.setDirection(AutoLoopViewPager.RIGHT);
        // 当滚动到最后一个时,是否添加动画
        bannerViewPager.setBorderAnimation(true);
        // 滚动一个item需要的时间()
        bannerViewPager.setAutoScrollDurationFactor(10);
        // 设置滚动间隔时间 默认1500毫秒
        bannerViewPager.setInterval(3000);
        BannerAdapter bannerAdapter = new BannerAdapter(this, imageIds);
        bannerViewPager.setAdapter(bannerAdapter);
        bannerViewPager.startAutoScroll();
    }

    private void initData() {
        imageIds = new ArrayList<>();
        imageIds.add(R.mipmap.guide01);
        imageIds.add(R.mipmap.guide02);
        imageIds.add(R.mipmap.guide03);
        imageIds.add(R.mipmap.guide04);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
