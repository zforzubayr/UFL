package com.vlogellaa.espresso.ufl.ui.fragments.tab_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllLeaguesFragment();
            case 1:
                return new SeriesFragment();
            case 2:
                return new PremierFragment();
            case 3:
                return new Ligue1Fragment();
            case 4:
                return new SaudiLeagueFragment();
            case 5:
                return new LaLigaFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
