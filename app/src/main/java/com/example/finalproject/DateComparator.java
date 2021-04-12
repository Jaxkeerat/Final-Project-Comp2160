package com.example.finalproject;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.Integer.valueOf;


public class DateComparator {

    private boolean expired = false;

    public boolean compareDate(String incoming) {
        /*
        Calendar todayCalendar = new GregorianCalendar(2015, Calendar.AUGUST, 24);
        Calendar yesterdayCalendar = new GregorianCalendar(2015, Calendar.AUGUST, 23);
        */
        String[] ss=incoming.split("/");

        // YY mm DD needed
        int[] ymd = new int[3];
        int count = 0;
        for(int i=2;i>=0;i--)
        {
            ymd[count] = valueOf(ss[i]);
            count++;
        }

        //Log.d("ymd of string is:" , ymd);

        LocalDate today = LocalDate.now();

        Log.d("Todays Date: ",today.toString());

        LocalDate compareMe = LocalDate.of(ymd[0],ymd[1],ymd[2]);

        Log.d("CompareMe Date; ", compareMe.toString());

        //compare finally
        boolean isbefore = false;
        isbefore = compareMe.isBefore(today);

        Log.d("Compare date vs today: ",compareMe.toString() + " " + today.toString() + " " +isbefore);

        return isbefore;
    }

}