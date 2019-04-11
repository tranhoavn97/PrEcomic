package com.example.developer.precomic.Adapter;

import android.content.Context;

import com.example.developer.precomic.Object.Banner;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;


public class AdapterSlider extends SliderAdapter {
    private List<Banner> list;

    public AdapterSlider(List<Banner> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(list.get(position).getLink());
    }
}
