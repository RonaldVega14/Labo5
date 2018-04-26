package com.pertuz.cardviewer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ronald Vega on 25/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>{
    private ArrayList<Serie> series;
    private Serie serie;
    private Context contexto;
    private Boolean favoritos;
    private  static Recycler_View1 rv1;
    private  static Recycler_View2 rv2;


    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new SeriesViewHolder(v, this.favoritos));
    }

    @Override
    public void onBindViewHolder(final SeriesViewHolder holder, final int position) {
        rv1 =Recycler_View1.getInstance();
        rv2 =Recycler_View2.getInstance();

        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());
        holder.btn.setImageResource(series.get(position).isFavoris()?R.drawable.star_full:R.drawable.star_empty);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),series.get(position).getName(),Toast.LENGTH_SHORT).show();

                if (!favoritos) {
                    if (!holder.fav) {
                        series.get(position).setFavoritos(true);
                        holder.btn.setImageResource(R.drawable.star_full);
                        holder.fav=true;
                    } else {
                        series.get(position).setFavoritos(false);
                        holder.btn.setImageResource(R.drawable.star_empty);
                        holder.fav=false;
                    }

                } else {
                    if (!holder.fav) {
                        series.get(position).setFavoritos(true);
                        holder.btn.setImageResource(R.drawable.star_full);
                        holder.fav = true;
                    } else {
                        series.get(position).setFavoritos(false);
                        holder.btn.setImageResource(R.drawable.star_empty);
                        holder.fav = false;
                    }
                }

                rv2.update(series);
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;
        ImageView btn;
        boolean fav;

        public SeriesViewHolder(View itemView, boolean Favoris) {
            super(itemView);
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
            btn = itemView.findViewById(R.id.btn);
            fav = Favoris;
        }

    }

    public SeriesAdapter(ArrayList<Serie> series, Context contexte, Boolean favoris) {
        this.series = series;
        this.contexto = contexte;
        this.favoritos = favoris;
    }
}
