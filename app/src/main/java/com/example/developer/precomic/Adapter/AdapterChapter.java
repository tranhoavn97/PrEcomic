package com.example.developer.precomic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.precomic.Common.Common;
import com.example.developer.precomic.Common.OnclickListenner;
import com.example.developer.precomic.Object.Chapter;
import com.example.developer.precomic.R;
import com.example.developer.precomic.ViewActivity;

import java.util.List;

public class AdapterChapter extends RecyclerView.Adapter<AdapterChapter.ViewHolderChapter> {
    Context context;
    List<Chapter> list;

    public AdapterChapter(Context context, List<Chapter> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderChapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(context).inflate(R.layout.item_chapter,viewGroup,false);
        return new ViewHolderChapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderChapter viewHolderChapter, int i) {
        viewHolderChapter.txtChapterName.setText(list.get(i).getName()+"");

//        Common.select_chapter=list.get(i);
//        Common.Chapter_index=i;
        viewHolderChapter.setOnclickListenner(new OnclickListenner() {
            @Override
            public void Onclick(View view, int position) {
                Common.select_chapter=list.get(position);
                Common.Chapter_index=position;
                context.startActivity(new Intent(context,ViewActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderChapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtChapterName;
        OnclickListenner onclickListenner;

        public void setOnclickListenner(OnclickListenner onclickListenner) {
            this.onclickListenner = onclickListenner;
        }
        public ViewHolderChapter(@NonNull View itemView) {
            super(itemView);
            txtChapterName=itemView.findViewById(R.id.txtChapterName);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onclickListenner.Onclick(view,getAdapterPosition());
        }
    }
}
