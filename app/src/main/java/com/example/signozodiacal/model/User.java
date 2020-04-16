package com.example.signozodiacal.model;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.signozodiacal.MainActivity;
import com.example.signozodiacal.R;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import androidx.annotation.NonNull;

public class User  implements Serializable {
    private String FirstName;
    private String LastName1,LastName2;
    private int Day,Month,Year;
    private int user_age;
    private String horoscope_chin;
    private String rfc;
    private String zodiac;
    private String characteristic,characteristic_ch;




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

    public int getUser_age() {
        return user_age;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getHoroscope_chin() {
        return horoscope_chin;
    }

    public void setHoroscope_chin(String horoscope_chin) {
        this.horoscope_chin = horoscope_chin;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getCharacteristic_ch() {
        return characteristic_ch;
    }

    public void setCharacteristic_ch(String characteristic_ch) {
        this.characteristic_ch = characteristic_ch;
    }

    public void computeAge()
    {
        int year,m,d;
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        m= cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DAY_OF_MONTH);
        m=m+1;
        this.user_age=year-this.Year;

        if(this.Month>m)
        {
            this.user_age=this.user_age-1;
        }
        else {
            if (this.Month==m & this.Day>d)
            {
                this.user_age=this.user_age-1;
            }
        }
    }

    public void computeRFC(){

        String year;
        this.rfc=Character.toString(this.LastName1.charAt(0));
        this.rfc+=Character.toString(this.LastName1.charAt(1));
        this.rfc+=Character.toString(this.LastName2.charAt(0));
        this.rfc+=Character.toString(this.FirstName.charAt(0));
        year=String.valueOf(this.Year);
        this.rfc+=Character.toString(year.charAt(2));
        this.rfc+=Character.toString(year.charAt(3));
        this.rfc+=String.valueOf(this.Month);
        this.rfc+=String.valueOf(this.Day);
    }

}
