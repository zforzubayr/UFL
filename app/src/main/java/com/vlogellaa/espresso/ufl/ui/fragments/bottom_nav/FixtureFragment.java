package com.vlogellaa.espresso.ufl.ui.fragments.bottom_nav;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.ui.fragments.tab_fragment.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixtureFragment extends Fragment {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public FixtureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fixture, container, false);
        ButterKnife.bind(this, view);

        this.setTabLayout();
        this.setPageAdapter();
        this.listenersForTabLayout();

        return view;
    }

    private void setTabLayout(){
        tabLayout.setSmoothScrollingEnabled(true);
        tabLayout.setScrollPosition(3, 0f, true);

        tabLayout.addTab(tabLayout.newTab().setText("All Leagues").setIcon(R.drawable.silver_icon));
        tabLayout.addTab(tabLayout.newTab().setText("Series A").setIcon(R.drawable.italy_badge));
        tabLayout.addTab(tabLayout.newTab().setText("Premiere League").setIcon(R.drawable.england));
        tabLayout.addTab(tabLayout.newTab().setText("League 1").setIcon(R.drawable.italy_badge));
        tabLayout.addTab(tabLayout.newTab().setText("Saudi League").setIcon(R.drawable.saudi_contest));
        tabLayout.addTab(tabLayout.newTab().setText("La Liga").setIcon(R.drawable.spain_contest));
        tabLayout.setTabGravity(TabLayout.MODE_FIXED);
    }


    private void setPageAdapter(){
        PagerAdapter adapter = new PagerAdapter(
                getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount()
        );

        viewPager.setAdapter(adapter);
    }


    private void listenersForTabLayout(){
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
