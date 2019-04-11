package com.example.developer.precomic.Model.Ecomic;

import android.util.Log;

import com.example.developer.precomic.Api.DownLoadJson;
import com.example.developer.precomic.Api.Server;
import com.example.developer.precomic.Object.Banner;
import com.example.developer.precomic.Object.Ecomic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelEcomic {

    public List<Ecomic> LoadEcomic()
    {
        List<Ecomic> listdata=new ArrayList<>();

        List<HashMap<String,String>> attrs=new ArrayList<>();
        String dataJSON="";
        //String duongdan= Server.ServerName;

        HashMap<String, String> hsFunction=new HashMap<>();
        hsFunction.put("myFunction","LoadManga");
        attrs.add(hsFunction);

        DownLoadJson downLoadJson=new DownLoadJson(Server.ServerName,attrs);
        //end phương thức post

        downLoadJson.execute();

        try {
            dataJSON=downLoadJson.get();
            Log.d("kt",dataJSON+"");
            JSONObject jsonObject=new JSONObject(dataJSON);

            JSONArray jsonArrayDanhSachEcomic=jsonObject.getJSONArray("DataManga");
            int count=jsonArrayDanhSachEcomic.length();
            for (int i = 0; i < count; i++) {
                Ecomic ecomic=new Ecomic();
                JSONObject object=jsonArrayDanhSachEcomic.getJSONObject(i);
                ecomic.setID(object.getInt("ID"));
                ecomic.setName(object.getString("Name"));
                ecomic.setImage(object.getString("Image"));
                listdata.add(ecomic);
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
