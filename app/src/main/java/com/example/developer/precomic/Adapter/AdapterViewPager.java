package com.example.developer.precomic.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.precomic.Object.Link;
import com.example.developer.precomic.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterViewPager extends PagerAdapter {

    Context context;
    List<Link> links;
    LayoutInflater layoutInflater;

    public AdapterViewPager(Context context, List<Link> links) {
        this.context = context;
        this.links = links;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return links.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        View image_layout=layoutInflater.inflate(R.layout.item_view_pager, (ViewGroup) container,false);
        PhotoView page_image=image_layout.findViewById(R.id.photoView);
        Picasso.get().load(links.get(position).getLink()).into(page_image);
        ((ViewGroup) container).addView(image_layout);
        return image_layout;
    }
}
