package com.vlogellaa.espresso.ufl.ui.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.ui.fragments.FixtureFragment;
import com.vlogellaa.espresso.ufl.util.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    ConstraintLayout constraintLayout;

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.setUpNavigationListener();
        this.setUpViews();
    }

    private void setUpNavigationListener(){
        mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.points:
                        frameLayout.removeAllViews();
                        return true;
                    case R.id.contests:
                        frameLayout.removeAllViews();
                        return true;
                    case R.id.fixtures:
                        replaceCurrentFragmentWith();
                        return true;

                    case R.id.profile:
                        frameLayout.removeAllViews();
                        return true;

                    case R.id.gam:
                        frameLayout.removeAllViews();
                        return true;

                }
                return false;
            }
        };
    }

    private void setUpViews(){
        constraintLayout.getBackground().setColorFilter(0xFF211F3D, PorterDuff.Mode.DARKEN);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

    public boolean replaceCurrentFragmentWith() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new FixtureFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        return true;
    }


}
