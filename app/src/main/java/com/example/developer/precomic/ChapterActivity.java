package com.example.developer.precomic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.precomic.Adapter.AdapterChapter;
import com.example.developer.precomic.Common.Common;
import com.example.developer.precomic.Model.Chapter.ModelChapter;
import com.example.developer.precomic.Object.Chapter;

import java.util.List;

public class ChapterActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txtChapter,txtMangaName;
    RecyclerView rvChapter;
//    int MangaID;
//    String MangaName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        toolbar=findViewById(R.id.mToolbar);
        txtChapter=findViewById(R.id.txtChapter);
        txtMangaName=findViewById(R.id.txtMangaName);
        setUpToolbar();
//        Intent intent=getIntent();
//        MangaName=intent.getStringExtra("EcomicName");
//        MangaID=intent.getIntExtra("EcomicID",0);

        txtMangaName.setText(Common.select_ecomic.getName());
        rvChapter=findViewById(R.id.rvChapter);
        rvChapter.setHasFixedSize(true);
        rvChapter.setLayoutManager(new LinearLayoutManager(this));
        fetchChapter();
    }

    private void fetchChapter() {
        List<Chapter> list =new ModelChapter().LoadChapter(Common.select_ecomic.getID());

        Common.chapterList=list;//lưu list chapter lại để back và next

        txtChapter.setText("CHAPTER ("+list.size()+")");

        AdapterChapter adapterChapter=new AdapterChapter(ChapterActivity.this,list);
        rvChapter.setAdapter(adapterChapter);

        adapterChapter.notifyDataSetChanged();

    }


    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if(getSupportActionBar() !=null)
        {
            Drawable drawable= ResourcesCompat.getDrawable(this.getResources(), R.drawable.ic_arrow_back_white_24dp, null);

            //custom color
            //drawable.setColorFilter(ResourcesCompat.getColor(this.getResources(), R.color.colorwhite, null), PorterDuff.Mode.SRC_IN);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(drawable);

        }
    }
    // trở về trang chủ
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
