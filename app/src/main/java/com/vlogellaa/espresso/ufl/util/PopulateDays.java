package com.vlogellaa.espresso.ufl.util;

import com.vlogellaa.espresso.ufl.models.Dates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class PopulateDays {
    private Date lastDate;

    public PopulateDays(Date lastDate) {
        this.lastDate = lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getLastDate() {
        return lastDate;
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

    private Flowable<ArrayList<Dates>> dataFromNetwork(final Date date) {
        return Flowable.just(true)
                .delay(1, TimeUnit.SECONDS)
                .map(new Function<Boolean, ArrayList<Dates>>() {
                    @Override
                    public ArrayList<Dates> apply(@NonNull Boolean value) throws Exception {
                        ArrayList<Dates> days = new ArrayList<>();
                        Date newDate = null;
                        for (int i = 1; i <= 10; i++) {
                            newDate = new Date(date.getTime() + (24*60*60*1000));
                            days.add(new Dates(fullDate(newDate)));
                        }
                        setLastDate(newDate);
                        return days;
                    }
                });
    }


/*    private String fullDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd yyyy");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        String month = new SimpleDateFormat("MMM").format(cal.getTime());
        String main_date = dateFormat.format(date);
        String[] splited = main_date.split("\\s+");
        return day + " " + splited[0] + " " + month + " " + splited[1];
    }*/


}
