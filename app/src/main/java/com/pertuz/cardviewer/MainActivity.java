package com.pertuz.cardviewer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series=new ArrayList<>();
        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);
        btn = findViewById(R.id.btn);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter=new SeriesAdapter(series);
        rv.setAdapter(adapter);


    }


    public void prepareSeries(){
        String TAG ="mensaje";
        series = new ArrayList<>();
        series.add(new Serie("The Walking death", "13", "Show created by Robert Kirgman" , R.drawable.twd));
        series.add(new Serie("Vikings", "13", "Show created by Michael Hirst", R.drawable.vik));
        series.add(new Serie("Game of thrones", "13", "Show created by Geaorge R. Martin",  R.drawable.got));



    }
}
