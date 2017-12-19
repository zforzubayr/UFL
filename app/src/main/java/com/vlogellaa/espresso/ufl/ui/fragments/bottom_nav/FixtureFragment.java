package com.vlogellaa.espresso.ufl.ui.fragments.bottom_nav;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.ui.fragments.RecycleAdapter;
import com.vlogellaa.espresso.ufl.util.JSONParser;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FixtureFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private JSONParser parser;

    public FixtureFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parser = new JSONParser(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture, container, false);
        ButterKnife.bind(this, view);

        this.setTabLayout();
        this.listenersForTabLayout();
        this.setUpRecyclerView();


        return view;
    }

    private void setTabLayout() {
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


    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        changeData(0);
    }


    private void changeData(int type) {
        RecycleAdapter adapter = new RecycleAdapter(parser.getList(type));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void listenersForTabLayout() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        changeData(0);
                        break;
                    case 1:
                        changeData(1);
                        break;
                    case 2:
                        changeData(2);
                        break;
                    case 3:
                        changeData(3);
                        break;
                    case 4:
                        changeData(4);
                        break;
                    case 5:
                        changeData(5);
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
