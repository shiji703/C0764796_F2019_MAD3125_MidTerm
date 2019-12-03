package com.example.c0764796_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CRACustomer extends AppCompatActivity
{
    EditText sinNumber, firstName, lastName, dob, grossIncome, rrspContributed;
    RadioGroup genderGroup;
    RadioButton radioGenderButton;
    Calendar myCalendar = Calendar.getInstance();
    private Calendar calendar;
    int day, month, year;
    private DatePickerDialog datePickerDialog;
    private int remaining;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sinNumber = (EditText) findViewById(R.id.sinNumber);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        dob = (EditText) findViewById(R.id.dob);
        grossIncome = (EditText) findViewById(R.id.grossIncome);
        rrspContributed = (EditText) findViewById(R.id.rrspContributed);
        genderGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        
