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
        int selectedId = genderGroup.getCheckedRadioButtonId();
        radioGenderButton = (RadioButton) findViewById(selectedId);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dob.setCursorVisible(false);
                datePickerDialog = new DatePickerDialog(CRACustomer.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year1,
                                                  int monthOfYear, int dayOfMonth) {
                                year = year1;
                                month = monthOfYear;
                                day = dayOfMonth;
                                datePickerDialog.updateDate(year, monthOfYear,
                                        dayOfMonth);
                                dob.setText((month + 1) + "/" + day + "/"
                                        + year);
                            }
                        }, year, month, day);
                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();
            }
        });

        findViewById(R.id.btnsubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sinNumber.length() != 0 && dob.length() != 0 && firstName.length() != 0 && lastName.length() != 0 && grossIncome.length() != 0 && rrspContributed.length() != 0) {
                    String sinNum = String.valueOf(sinNumber.getText());
                    String dateofBirth = String.valueOf(dob.getText());
                    String fname = String.valueOf(firstName.getText());
                    String lname = String.valueOf(lastName.getText());
                    String grsinc = String.valueOf(grossIncome.getText());
                    String rrspcntr = String.valueOf(rrspContributed.getText());
                    double grossInc = Double.parseDouble(grsinc);
                    double rrspcntrr = Double.parseDouble(rrspcntr);
                    if (sinNum.length() == 9) {
                        String eightDigits = sinNum.substring(0, 8);
                        String checkDigit = sinNum.substring(8);
                        System.out.println("The first eight digits are: " + eightDigits);
                        System.out.println("The Check-digit is: " + checkDigit);

