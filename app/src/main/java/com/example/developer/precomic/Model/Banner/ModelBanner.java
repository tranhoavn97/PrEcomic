package com.example.developer.precomic.Model.Banner;

import android.util.Log;


import com.example.developer.precomic.Api.DownLoadJson;
import com.example.developer.precomic.Api.Server;
import com.example.developer.precomic.Object.Banner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelBanner {

    public List<Banner> LoadBanner()
    {
        List<Banner> listdata=new ArrayList<>();

        List<HashMap<String,String>> attrs=new ArrayList<>();
        String dataJSON="";
        //String duongdan= Server.ServerName;

        HashMap<String, String> hsFunction=new HashMap<>();
        hsFunction.put("myFunction","LoadBanner");
        attrs.add(hsFunction);

        DownLoadJson downLoadJson=new DownLoadJson(Server.ServerName,attrs);
        //end phương thức post

        downLoadJson.execute();

        try {
            dataJSON=downLoadJson.get();
            Log.d("kt",dataJSON+"");
            JSONObject jsonObject=new JSONObject(dataJSON);

            JSONArray jsonArrayDanhSachLoaiSanPham=jsonObject.getJSONArray("LoadBanner");
            int count=jsonArrayDanhSachLoaiSanPham.length();
            for (int i = 0; i < count; i++) {
                Banner banner=new Banner();
                JSONObject object=jsonArrayDanhSachLoaiSanPham.getJSONObject(i);
                banner.setID(object.getInt("ID"));
                banner.setLink(object.getString("Link"));

                listdata.add(banner);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("kt",listdata.size()+"");
        return listdata;

    }
}
