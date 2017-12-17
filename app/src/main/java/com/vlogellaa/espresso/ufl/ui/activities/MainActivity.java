package com.vlogellaa.espresso.ufl.ui.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.vlogellaa.espresso.ufl.R;
import com.vlogellaa.espresso.ufl.models.Dates;
import com.vlogellaa.espresso.ufl.ui.fragments.bottom_nav.FixtureFragment;
import com.vlogellaa.espresso.ufl.util.BottomNavigationViewHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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
        getGo();
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


    private void getGo(){
        DateFormat dateFormat = new SimpleDateFormat("dd yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        newMethod(date);
//        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
//        String month = new SimpleDateFormat("MMM").format(cal.getTime());
//        String main_date = dateFormat.format(date);
//        String[] splited = main_date.split("\\s+");
//        String full_date = day + " " + splited[0] + " " + month + " " + splited[1];
//
//        Log.d(TAG, "getGo: " + full_date);
//
//
//        cal.setTime(date);
//        cal.add(Calendar.DATE, 10);
    }

    private void newMethod(Date date){
        ArrayList<Dates> days = new ArrayList<>();
        Date newDate = null;
        for (int i = 1; i <= 10; i++) {
            newDate = new Date(date.getTime() + (24*60*60*1000));
            days.add(new Dates(fullDate(newDate)));
        }

        for(Dates dates : days){
            Log.d(TAG,
                    "newMethod: Time " +  dates.getGames().get(0).getTeam_two() + " -- " +
                            dates.getGames().get(0).getTeam_one() +
                            " vs " + dates.getGames().get(0).getTime()
            );
        }
    }

    private String fullDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd yyyy");
        Calendar cal = Calendar.getInstance();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        String month = new SimpleDateFormat("MMM").format(cal.getTime());
        String main_date = dateFormat.format(date);
        String[] split = main_date.split("\\s+");
        return day + " " + split[0] + " " + month + " " + split[1];
    }

}
