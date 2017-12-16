package com.vlogellaa.espresso.ufl.ui.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.ui.fragments.bottom_nav.FixtureFragment;
import com.vlogellaa.espresso.ufl.util.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {


    ConstraintLayout constraintLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.points:
                    return true;
                case R.id.contests:
                    return true;
                case R.id.fixtures:
                    replaceCurrentFragmentWith();
                    return true;

                case R.id.profile:
                    return true;

                case R.id.gam:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.container);
        constraintLayout.getBackground().setColorFilter(0xff0000ff, PorterDuff.Mode.DARKEN );
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }


    public boolean replaceCurrentFragmentWith() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //animation here
        transaction.replace(R.id.frame_layout, new FixtureFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        return true;
    }

}
