package com.liuhw.autoloopviewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liuhw.autoloopviewpager.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liuhw on 15/10/21.
 *
 */
public class BannerAdapter extends PagerAdapter {

    private int count = Integer.MAX_VALUE;
    private Queue<View> views;
    // 加载本地图片,直接用资源id,也可以用imageLoader加载网络图片
    private ArrayList<Integer> imageIds;
    private LayoutInflater inflater;
    private Context context;

    public BannerAdapter(Context context, ArrayList<Integer> data) {
        views = new LinkedList<>();
        this.context = context;
        this.imageIds = data;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return imageIds.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.poll();
        if (view == null) {
            view = inflater.inflate(R.layout.item_home_banner, null);
            view.setId(count++);
        }
        ImageView imageView = (ImageView)view.findViewById(R.id.img);
        imageView.setBackgroundResource(imageIds.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        views.add(view);
        container.removeView(view);
    }
}
