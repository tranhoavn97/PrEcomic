package com.example.developer.precomic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.precomic.ChapterActivity;
import com.example.developer.precomic.Common.Common;
import com.example.developer.precomic.Common.OnclickListenner;
import com.example.developer.precomic.Object.Ecomic;
import com.example.developer.precomic.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterEcomic extends RecyclerView.Adapter<AdapterEcomic.EcomicViewHolder> {
    Context context;
    List<Ecomic> list;

    public AdapterEcomic(Context context, List<Ecomic> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EcomicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=LayoutInflater.from(context).inflate(R.layout.item_ecomic,viewGroup,false);
        return new EcomicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final EcomicViewHolder ecomicViewHolder, int i) {
        ecomicViewHolder.txtEcomicName.setText(list.get(i).getName());
        Picasso.get().load(list.get(i).getImage()).into(ecomicViewHolder.imagEcomic, new Callback() {
            @Override
            public void onSuccess() {
                ecomicViewHolder.progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
        ecomicViewHolder.setOnclickListenner(new OnclickListenner() {
            @Override
            public void Onclick(View view, int position) {

                context.startActivity(new Intent(context,ChapterActivity.class));
                Common.select_ecomic=list.get(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EcomicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtEcomicName;
        ImageView imagEcomic;
        ProgressBar progress;
        OnclickListenner onclickListenner;

        public void setOnclickListenner(OnclickListenner onclickListenner) {
            this.onclickListenner = onclickListenner;
        }

        public EcomicViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEcomicName=itemView.findViewById(R.id.txtEcomicName);
            imagEcomic=itemView.findViewById(R.id.imgEcomic);
            progress=itemView.findViewById(R.id.progress);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onclickListenner.Onclick(view,getAdapterPosition());
        }
    }
}
