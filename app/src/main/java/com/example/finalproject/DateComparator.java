package com.example.finalproject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateComparator {

    private boolean expired = false;

    public boolean compareDate(String incoming) {

        Calendar todayCalendar = new GregorianCalendar(2015, Calendar.AUGUST, 24);
        Calendar yesterdayCalendar = new GregorianCalendar(2015, Calendar.AUGUST, 23);

        Date today = todayCalendar.getTime();
        Date yesterday = yesterdayCalendar.getTime();

        // checking which dates comes first
        // you can use before() and after() method of Calendar class
        if(todayCalendar.after(yesterdayCalendar)){
            System.out.println("first date comes after second date");
        }

        // Date class also has their own before() and after() method
        if(yesterday.before(today)){
            System.out.println("yesterday comes before today");
        }
        return false;
    }

}