package com.example.signozodiacal.model;

import java.io.Serializable;

public class User implements Serializable {
    private String FirstName;
    private String LastName1,LastName2;
    private int Day,Month,Year;





    public User(String firstName, String lastName1, String lastName2, int day, int month, int year) {
        FirstName = firstName;
        LastName1 = lastName1;
        LastName2 = lastName2;
        Day = day;
        Month = month;
        Year = year;
    }

    public User(int day, int month, int year) {
        Day = day;
        Month = month;
        Year = year;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String lastName1) {
        LastName1 = lastName1;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String lastName2) {
        LastName2 = lastName2;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
