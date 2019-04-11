package com.example.developer.precomic.Model.Chapter;

import android.util.Log;

import com.example.developer.precomic.Api.DownLoadJson;
import com.example.developer.precomic.Api.Server;
import com.example.developer.precomic.Object.Chapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelChapter {

    public List<Chapter> LoadChapter(int MangaID)
    {
        List<Chapter> listdata=new ArrayList<>();

        List<HashMap<String,String>> attrs=new ArrayList<>();
        String dataJSON="";
        //String duongdan= Server.ServerName;

        HashMap<String, String> hsFunction=new HashMap<>();
        hsFunction.put("myFunction","LoadChapter");

        HashMap<String, String> hsMangaID=new HashMap<>();
        hsMangaID.put("MangaID", String.valueOf(MangaID));
        attrs.add(hsFunction);
        attrs.add(hsMangaID);
        DownLoadJson downLoadJson=new DownLoadJson(Server.ServerName,attrs);
        Log.d("tab",downLoadJson.toString());
        //end phương thức post

        downLoadJson.execute();

        try {
            dataJSON=downLoadJson.get();
            Log.d("kt",dataJSON+"");

            JSONObject jsonObject=new JSONObject(dataJSON);


            JSONArray jsonArrayChapter=jsonObject.getJSONArray("DataChapter");

            int count=jsonArrayChapter.length();
            for (int i = 0; i < count; i++) {
                Chapter chapter=new Chapter();
                JSONObject object=jsonArrayChapter.getJSONObject(i);
                //chapter.setMangaID(object.getInt("MangaID"));
                chapter.setID(object.getInt("ID"));
                chapter.setName(object.getString("Name"));
                listdata.add(chapter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("check1",listdata.size()+"");
        return listdata;
    }
}
