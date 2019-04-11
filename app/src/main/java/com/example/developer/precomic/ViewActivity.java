package com.example.developer.precomic;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.precomic.Adapter.AdapterViewPager;
import com.example.developer.precomic.Common.Common;
import com.example.developer.precomic.Model.Link.ModelLink;
import com.example.developer.precomic.Object.Chapter;
import com.example.developer.precomic.Object.Link;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView txtChapterName;
    View back,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewPager=findViewById(R.id.viewPager);
        txtChapterName=findViewById(R.id.txtChapterName);
        //txtChapterName.setText(Common.select_chapter.getName());
//        back=findViewById(R.id.back);
//        next=findViewById(R.id.next);
        fetchLinks(Common.select_chapter.getID());
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(Common.Chapter_index==0)
//                {
//                    Toast.makeText(ViewActivity.this, "Bạn đang ở Chapter đầu tiên", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Common.Chapter_index--;
//                    fetchLinks(Common.chapterList.get(Common.Chapter_index).getID());
//                }
//                Toast.makeText(ViewActivity.this, ""+Common.chapterList.get(Common.Chapter_index).getID(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(ViewActivity.this, ""+Common.select_chapter, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(Common.Chapter_index==Common.chapterList.size()-1)
//                {
//                    Toast.makeText(ViewActivity.this, "Bạn đang ở Chapter cuối", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Common.Chapter_index++;
//                    fetchLinks(Common.chapterList.get(Common.Chapter_index).getID());
//                }
//            }
//        });
    }

    private void fetchLinks(int id) {

        List<Link> linkList=new ModelLink().LoadChapter(id);
        if(linkList.size()<=0)
        {
            Toast.makeText(this, "Chưa có dữ liệu", Toast.LENGTH_SHORT).show();
        }
        else
        {
            AdapterViewPager adapterViewPager=new AdapterViewPager(getApplicationContext(),linkList);
            viewPager.setAdapter(adapterViewPager);
        }

    }


}
