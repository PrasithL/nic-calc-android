package com.dreikurs.niccalc;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Prasith Lakshan on 8/27/15.
 */
public class Calculator {

    static String[] bDay(int nic) {
        int year;

        // getting the year
        int yearNIC = nic/10000000;

        if(yearNIC < 30) {
            year = 2000 + yearNIC;
        } else {
            year = 1900 + yearNIC;
        }
        //System.out.println("\nbDay: " + year);
        String gender = "Male";
        //getting the month
        int monthNIC = (nic - yearNIC * 10000000) / 10000;
        if (monthNIC > 500) {
            monthNIC -= 500;
            gender = "Female";
        }

        String month = "";
        int M = 0;
        int date = 0;

        if(monthNIC <= 31) {
            month = "January";
            M = 1;
            date = monthNIC;

        } else if(monthNIC <= 60) {
            month = "February";
            M = 2;
            date = monthNIC - 31;

        } else if(monthNIC <= 91) {
            month = "March";
            M = 3;
            date = monthNIC - 60;

        } else if(monthNIC <= 121) {
            month = "April";
            M = 4;
            date = monthNIC - 91;

        } else if(monthNIC <= 152) {
            month = "May";
            M = 5;
            date = monthNIC - 121;

        } else if(monthNIC <= 182) {
            month = "June";
            M = 6;
            date = monthNIC - 152;

        } else if(monthNIC <= 213) {
            month = "July";
            M = 7;
            date = monthNIC - 182;

        } else if(monthNIC <= 244) {
            month = "August";
            M = 8;
            date = monthNIC - 213;

        } else if(monthNIC <= 274) {
            month = "September";
            M = 9;
            date = monthNIC - 244;

        } else if(monthNIC <= 305) {
            month = "Octomber";
            M = 10;
            date = monthNIC - 274;

        } else if(monthNIC <= 335) {
            month = "November";
            M = 11;
            date = monthNIC - 305;

        } else if(monthNIC <= 366) {
            month = "December";
            M = 12;
            date = monthNIC - 335;

        }

        // display birthday
        //System.out.println("\n>> Your Birthday is: " + year + "-" + month + "-" + date + "\n>> Gender: " + gender + "\n");
        String bday = year + "-" + month + "-" + date;

        //get age
        String age = age(year, M, date);

        return new String[]{bday, gender, age};

    }

    private static String age(int Y1, int M1, int D1) {
        int Y, M, D;

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();

        int Y2 = Integer.parseInt(yearFormat.format(cal.getTime()));
        int M2 =  Integer.parseInt(monthFormat.format(cal.getTime()));
        int D2 = Integer.parseInt(dateFormat.format(cal.getTime()));

        /*
        System.out.println(yearFormat.format(cal.getTime()));
        System.out.println(monthFormat.format(cal.getTime()));
        System.out.println(dateFormat.format(cal.getTime()));
        */

        // calculate Years
        Y = Y2 - Y1;

        //calculate months
        if (M1 > M2) {
            M = (13 - M1) + ( M2 - 1);
            Y = Y - 1;
        } else {
            M = M2 - M1;
        }

        //calculate days
        if (D1 > D2) {
            if (M2 == 3) {
                D = (28 - D1) + (D2);
            } else {
                D = (30 - D1) + ( D2);
            }


            if (M > 0) {
                M = M - 1;
            } else {
                M = 11;
                Y = Y - 1;
            }
        }else {
            D = D2 - D1;
        }


        //System.out.println(Y + ", " + M + ", " + D);
        return String.format("%d Years, %d Months, %d Days", Y, M, D);
    }

}
