package com.example.developer.precomic.Model.User;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.developer.precomic.Api.DownLoadJson;
import com.example.developer.precomic.Api.Server;
import com.example.developer.precomic.Object.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelUser {

    public boolean Login(String TenDn, String Pwd)
    {
        boolean check=false;

        List<HashMap<String, String >> attrs=new ArrayList<>();

        HashMap<String, String> hsFunction=new HashMap<>();
        hsFunction.put("myFunction","Login");

        HashMap<String, String> hsTenDN=new HashMap<>();
        hsTenDN.put("Username",TenDn);

        HashMap<String, String> hsPwd=new HashMap<>();
        hsPwd.put("Password", Pwd);

        attrs.add(hsFunction);
        attrs.add(hsTenDN);
        attrs.add(hsPwd);


        DownLoadJson downLoadJson=new DownLoadJson(Server.ServerName,attrs);

        downLoadJson.execute();
        //parse json
        try {
            String data=downLoadJson.get();



            JSONObject jsonObject=new JSONObject(data);
//            Log.d("ok",jsonObject+"");
//            Log.d("ok",data+"");
            String jsResult=jsonObject.getString("ketqua");


            if(jsResult.equals("true"))
            {
                check=true;
            }
            else
            {
                check=false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("ok",check+"");
        return check;
    }

    public Boolean RegisterMember(User user)
    {
        boolean check=false;
        String DuongDan= Server.ServerName;

        List<HashMap<String,String>> list = new ArrayList<>();
        //tạo tham số;
        HashMap<String,String> myFunction = new HashMap<>();
        myFunction.put("myFunction","Register");

        HashMap<String,String> hsTaiKhoan = new HashMap<>();
        hsTaiKhoan.put("Username",user.getUsername());
        HashMap<String,String> hsTenDayDu = new HashMap<>();
        hsTenDayDu.put("Fullname",user.getFullname());
        HashMap<String,String> hsMatKhau = new HashMap<>();
        hsMatKhau.put("Password",user.getPassword());


        list.add(myFunction);
        list.add(hsTaiKhoan);
        list.add(hsTenDayDu);
        list.add(hsMatKhau);



        DownLoadJson downLoadJson = new DownLoadJson(DuongDan,list);
        downLoadJson.execute();
        try {
            String dataJSON=downLoadJson.get();
            Log.d("kt",dataJSON);
            // parse về jsonobjec
            JSONObject jsonObject=new JSONObject(dataJSON);
            String dataResult=jsonObject.getString("ketqua");
            if(dataResult.equals("true"))
            {
                check= true;
            }
            else
            {
                check= false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return check;
    }
}
