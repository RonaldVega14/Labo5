package com.pertuz.cardviewer;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Serie> series;
    TabLayout tabs;
    ViewPager views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prepareSeries();

        Bundle bungalo= new Bundle();
        bungalo.putParcelableArrayList("KEY",series);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        views = findViewById(R.id.pags);
        tabs = findViewById(R.id.tabs);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this,getSupportFragmentManager(),bungalo);

        views.setAdapter(adapter);
        tabs.setupWithViewPager(views);

    }


    public void prepareSeries(){
        String TAG ="mensaje";
        series = new ArrayList<>();
        series.add(new Serie("The Walking death", "13", "Show created by Robert Kirgman" , R.drawable.twd, false));
        series.add(new Serie("Vikings", "13", "Show created by Michael Hirst", R.drawable.vik, false));
        series.add(new Serie("Game of thrones", "13", "Show created by Geaorge R. Martin",R.drawable.got, false));



    }
}
