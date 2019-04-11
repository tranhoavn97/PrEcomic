package com.example.developer.precomic.Model.Link;

import android.util.Log;

import com.example.developer.precomic.Api.DownLoadJson;
import com.example.developer.precomic.Api.Server;
import com.example.developer.precomic.Object.Chapter;
import com.example.developer.precomic.Object.Link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelLink {

    public List<Link> LoadChapter(int ChapterID)
    {
        List<Link> listdata=new ArrayList<>();

        List<HashMap<String,String>> attrs=new ArrayList<>();
        String dataJSON="";
        //String duongdan= Server.ServerName;

        HashMap<String, String> hsFunction=new HashMap<>();
        hsFunction.put("myFunction","LoadLink");

        HashMap<String, String> hsMangaID=new HashMap<>();
        hsMangaID.put("ChapterID", String.valueOf(ChapterID));
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


            JSONArray jsonArrayChapter=jsonObject.getJSONArray("DataLink");

            int count=jsonArrayChapter.length();
            for (int i = 0; i < count; i++) {
                Link link=new Link();
                JSONObject object=jsonArrayChapter.getJSONObject(i);
                //chapter.setMangaID(object.getInt("MangaID"));
                //chapter.setID(object.getInt("ID"));
                link.setLink(object.getString("Link"));
                listdata.add(link);
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
