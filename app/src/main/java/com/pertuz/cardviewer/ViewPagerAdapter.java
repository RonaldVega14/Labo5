package com.pertuz.cardviewer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context Contexto;
    private final Bundle bungalo;
    private Recycler_View1 serie;
    private Recycler_View2 favSerie;

    public ViewPagerAdapter(Context context, FragmentManager fm, Bundle bungalo) {
        super(fm);
        Contexto = context;
        this.bungalo = bungalo;
        this.serie = Recycler_View1.newInstance(bungalo.<Serie>getParcelableArrayList("KEY"));
        this.favSerie = Recycler_View2.newInstance(bungalo.<Serie>getParcelableArrayList("KEY"));
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return serie;
        } else if (position == 1) {
            return favSerie;
        }else{
            return serie;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return Contexto.getString(R.string.tab1);
            case 1:
                return Contexto.getString(R.string.tab2);
            default:
                return null;
        }
    }
}
