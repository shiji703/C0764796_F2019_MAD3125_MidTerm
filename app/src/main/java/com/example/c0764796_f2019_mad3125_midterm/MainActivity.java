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
public class CRACustomer extends AppCompatActivity {
    EditText sinNumber, firstName, lastName, dob, grossIncome, rrspContributed;
    RadioGroup genderGroup;
    RadioButton radioGenderButton;
    Calendar myCalendar = Calendar.getInstance();
    private Calendar calendar;
    int day, month, year;
    private DatePickerDialog datePickerDialog;
    private int remaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                    final String mAge = String.valueOf(getAge(dateofBirth));
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
                        int total;
                        int total2 = 0;
                        int counter = 0;
                        int first = Integer.parseInt(eightDigits.substring(0, 1)) * 1;
                        int second = Integer.parseInt(eightDigits.substring(1, 2)) * 2;
                        int third = Integer.parseInt(eightDigits.substring(2, 3)) * 1;
                        int fourth = Integer.parseInt(eightDigits.substring(3, 4)) * 2;
                        int fifth = Integer.parseInt(eightDigits.substring(4, 5)) * 1;
                        int sixth = Integer.parseInt(eightDigits.substring(5, 6)) * 2;
                        int seventh = Integer.parseInt(eightDigits.substring(6, 7)) * 1;
                        int eighth = Integer.parseInt(eightDigits.substring(7, 8)) * 2;
                        if (second > 9) {
                            int firstHalf = second / 10;
                            int secondHalf = second % 10;
                            int sum = firstHalf + secondHalf;
                            second = sum;
                        }
                        if (fourth > 9) {
                            int firstHalf1 = fourth / 10;
                            int secondHalf1 = fourth % 10;
                            int sum1 = firstHalf1 + secondHalf1;
                            fourth = sum1;
                        }
                        if (sixth > 9) {
                            int firstHalf2 = sixth / 10;
                            int secondHalf2 = sixth % 10;
                            int sum2 = firstHalf2 + secondHalf2;
                            sixth = sum2;
                        }
                        if (eighth > 9) {
                            int firstHalf3 = eighth / 10;
                            int secondHalf3 = eighth % 10;
                            int sum3 = firstHalf3 + secondHalf3;
                            eighth = sum3;
                        }
                        total = first + second + third + fourth + fifth + sixth + seventh + eighth;
                        System.out.println("This is the total so far: " + total);
                        total2 = total;
                        while (total > 0) {
                            counter++;
                            total = total - 10;
                        }
                        int result = counter * 10;
                        System.out.println("This is the next highest number divisble by 10: " + result);
                        remaining = result - total2;
                        String ewref = String.valueOf(sinNumber.getText());
                        if (remaining == Integer.parseInt(checkDigit)) {
                            System.out.println("You've entered a valid Social Insurance Number.");
                        } else {
                            System.out.println("Invalid Social Insurance Number.");
                        }
                        if (mAge >= 18) {
                            String mIncome = String.valueOf(grossIncome.getText());
                            String upperString = fname.substring(0, 1).toUpperCase() + fname.substring(1);
                            final String both = lname.toUpperCase() + "," + upperString;
                            System.out.println("dddddddd  " + dateofBirth + "  " + mAge + " " + both);
                            Date c = Calendar.getInstance().getTime();
                            System.out.println("Current time => " + c);
                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
                            final String formattedDate = df.format(c);
                            Intent intent = new Intent(CRACustomer.this, SecondActivity.class);
                            intent.putExtra("fullName", both);
                            intent.putExtra("age", mAge);
                            intent.putExtra("currentdate", formattedDate);
                            intent.putExtra("grossInc", grossInc);
                            intent.putExtra("rrspContribution", rrspcntrr);
                            startActivity(intent);
                        } else {
                            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/SpaceQuestItalic-60Rx.ttf");
                            SpannableString spannableString = new SpannableString(" Not eligible to file tax for current year 2019 ");
                            spannableString.setSpan(
                                    new ForegroundColorSpan(getResources().getColor(android.R.color.holo_red_dark)),
                                    0,
                                    spannableString.length(),
                                    0);
                            spannableString.setSpan(new TypefaceSpan(font), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            Toast.makeText(CRACustomer.this, spannableString, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //                            https://www.dreamincode.net/forums/topic/233396-validating-sin-number-reducing-amount-of-code/
                        sinNumber.setError("Invalid Social Insurance Number");
                    }
                } else {
                    Toast.makeText(CRACustomer.this, "Must fill all the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getAge(String dobString) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            date = sdf.parse(dobString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) return 0;
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.setTime(date);
        int year = dob.get(Calendar.YEAR);
        int month = dob.get(Calendar.MONTH);
        int day = dob.get(Calendar.DAY_OF_MONTH);
        dob.set(year, month + 1, day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
}



