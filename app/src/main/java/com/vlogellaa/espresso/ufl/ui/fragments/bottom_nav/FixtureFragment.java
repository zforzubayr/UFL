package com.vlogellaa.espresso.ufl.ui.fragments.bottom_nav;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.models.Dates;
import com.vlogellaa.espresso.ufl.models.Game;
import com.vlogellaa.espresso.ufl.ui.fragments.RecycleAdapter;
import com.vlogellaa.espresso.ufl.util.JSONParser;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixtureFragment extends Fragment {
    private static final String TAG = "FixtureFragment";

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private int current = 0;
    private ArrayList<Object> lists;
    private RecycleAdapter adapter;
    private JSONParser parser;

    public FixtureFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parser = new JSONParser(getContext());
        lists = new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: starrts");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fixture, container, false);
        ButterKnife.bind(this, view);

        this.setTabLayout();
        this.listenersForTabLayout();
        this.setUpRecyclerView();


        return view;
    }

    private void setTabLayout(){
        Log.d(TAG, "setTabLayout: starts");
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


    private void setUpRecyclerView(){
        Log.d(TAG, "setUpRecyclerView: starts");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lists = parser.getList(0);
        Log.d(TAG, "setUpRecyclerView: lists " + ((Game)lists.get(1)).getTeam_two() );
        adapter = new RecycleAdapter(parser.getList(0));
        recyclerView.setAdapter(adapter);
    }


    private void changeData(int type){
        lists = parser.getList(type);
//        Log.d(TAG, "setUpRecyclerView: lists " + ((Game)lists.get(1)).getTeam_two() );
        Log.d(TAG, "changeData: " + lists.size());
        adapter = new RecycleAdapter(parser.getList(type));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void listenersForTabLayout(){
        Log.d(TAG, "listenersForTabLayout: starts");
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Log.d(TAG, "onTabSelected: 0 should be All Leagues");
                        changeData(0);
                        break;
                    case 1:
                        Log.d(TAG, "onTabSelected: 1 should be Series A");
                        changeData(1);
                        break;
                    case 2:
                        Log.d(TAG, "onTabSelected: 2 should be PRemiere Leagues");
                        changeData(2);
                        break;
                    case 3:
                        Log.d(TAG, "onTabSelected: 3 should be LEage 1");
                        changeData(3);
                        break;
                    case 4:
                        Log.d(TAG, "onTabSelected: 4 should be Saudi");
                        changeData(4);
                        break;
                    case 5:
                        changeData(5);
                        Log.d(TAG, "onTabSelected: 5 should be la liga");
                        break;

                }
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
