package com.pertuz.cardviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Recycler_View2 extends Fragment {
    private RecyclerView rv;
    private SeriesAdapter adapter;
    private LinearLayoutManager lManager;
    private ArrayList<Serie> series;
    public  static ArrayList<Serie> favoritos;
    private static Recycler_View2 rv2;
    private Recycler_View1 rv1;

    public Recycler_View2() {
        // Required empty public constructor
    }

    public static Recycler_View2 newInstance(ArrayList<Serie> seriees){
        Recycler_View2 frags = new Recycler_View2();
        Bundle args = new Bundle();
        args.putParcelableArrayList("KEY2",seriees);
        frags.setArguments(args);
        return frags;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            series = getArguments().getParcelableArrayList("KEY2");
        }
        this.rv2 = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recyclerview2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState ){
        super.onViewCreated(view, savedInstanceState);

        favoritos = new ArrayList<>();

        rv = getView().findViewById(R.id.recycler2);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(lManager);

        favoritos = prepareFavSeries(series);
        adapter = new SeriesAdapter(favoritos, this.getContext(),true);

        rv.setAdapter(adapter);
    }


    @Override
    public void onResume() {
        adapter.notifyDataSetChanged();
        Log.d("LifeCycle", "On Resume");
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static Recycler_View2 getInstance(){
        return rv2;
    }

    public ArrayList<Serie> prepareFavSeries(ArrayList<Serie> series){
        ArrayList<Serie> favoritos = new ArrayList<>();
        for (int i = 0; i<series.size();i++){
            if (series.get(i).isFavoris() == true){
                favoritos.add( new Serie(series.get(i).getName(),series.get(i).getCaps(),series.get(i).getImg(),series.get(i).getDesc(),series.get(i).isFavoris()));
            }
        }


        return favoritos;
    }

    public void updateFavSeries(ArrayList<Serie> series){
        ArrayList<Serie> favseries = new ArrayList<>();
        for (int i = 0; i<series.size();i++){
            if (series.get(i).isFavoris() == true){
                favseries.add( new Serie(series.get(i).getName(),series.get(i).getCaps(),series.get(i).getImg(),series.get(i).getDesc(),series.get(i).isFavoris()));
                adapter.notifyDataSetChanged();
            }
        }
    }


    public void update(ArrayList<Serie> serieees) {
        Log.d("LifeCycle", "On Update");
        favoritos =prepareFavSeries(serieees);
        adapter = new SeriesAdapter(favoritos, this.getContext(),true);
        rv.setAdapter(adapter);
    }
}
