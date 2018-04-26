package com.pertuz.cardviewer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Recycler_View1 extends Fragment{

    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;
    private Recycler_View2 rv2;
    private static Recycler_View1 rv1;

    public Recycler_View1() {
        // Required empty public constructor
    }

    public static Recycler_View1 newInstance(ArrayList<Serie> series){
        Recycler_View1 fragms = new Recycler_View1();
        Bundle args = new Bundle();
        args.putParcelableArrayList("KEY1",series);
        fragms.setArguments(args);
        return fragms;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            series = getArguments().getParcelableArrayList("KEY1");
        }
        this.rv1 = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.recyclerviewf1, container, false);
        return views;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv= getView().findViewById(R.id.recycler1);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(lManager);


        adapter = new SeriesAdapter(series, this.getContext(), false);
        rv.setAdapter(adapter);
    }


    public static Recycler_View1 getInstance(){
        return rv1;
    }

    public void update(ArrayList<Serie> serieees, int position, Boolean fav) {
        Log.d("LifeCycle", "Fragmento 1... ");
        for (int i=0;i<series.size();i++){
            if(series.get(i).getName().equals(serieees.get(position).getName())){
                series.get(i).setFavoritos(fav);
                Log.d("LifeCycle Update", series.get(i).getName());
            }
        }
        adapter = new SeriesAdapter(series, this.getContext(),false);
        rv.setAdapter(adapter);
    }


}
