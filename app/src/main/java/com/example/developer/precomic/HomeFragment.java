package com.example.developer.precomic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developer.precomic.Adapter.AdapterEcomic;
import com.example.developer.precomic.Adapter.AdapterSlider;
import com.example.developer.precomic.Api.PicassoImageLoading;
import com.example.developer.precomic.Model.Banner.ModelBanner;
import com.example.developer.precomic.Model.Ecomic.ModelEcomic;
import com.example.developer.precomic.Object.Banner;
import com.example.developer.precomic.Object.Ecomic;

import java.util.List;

import ss.com.bannerslider.Slider;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Slider slider;
    ModelBanner modelBanner;
    RecyclerView rvEcomic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.home_fragment, container, false);
        slider=view.findViewById(R.id.slBanner);
        rvEcomic=view.findViewById(R.id.rvEcomic);
        rvEcomic.setHasFixedSize(true);
        rvEcomic.setLayoutManager(new GridLayoutManager(getContext(),2));
        Slider.init(new PicassoImageLoading());
        fetchBanner();
        fetchEcomic();
        return view;
    }

    private void fetchEcomic() {
        List<Ecomic> list=new ModelEcomic().LoadEcomic();
        AdapterEcomic adapterEcomic=new AdapterEcomic(getContext(),list);
        rvEcomic.setAdapter(adapterEcomic);
        adapterEcomic.notifyDataSetChanged();
    }

    private void fetchBanner() {
        modelBanner=new ModelBanner();
        List<Banner> bannerList=modelBanner.LoadBanner();
        slider.setAdapter(new AdapterSlider(bannerList));
    }

}
