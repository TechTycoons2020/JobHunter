package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jobhunter.utils.MonthYearPickerDialog;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {

    Button nextBT, yesBT, noBT,studentBT,workinBT;
    Spinner qualSP, examSP, courseSP, langSP;
    EditText yearofpassET, marksET;
    RelativeLayout examRL;
    NestedScrollView scrollView;

    Spinner qual2SP, salarySP, availabilitySP;
    TextView fromTV, toTV;
    EditText jobET, companyET;
    RelativeLayout workingRL;
    LinearLayout studentLL,workingLL;
    String value = "";


    //Spinner populations
    ArrayAdapter<String> qualADP, examADP, course12ADP, courseugADP, langADP,salaryADP, availADP;
    ArrayList<String> qualAL, examAL, course12AL, courseugAL, langAL, salaryAL, availAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        intiUI();

        //data filling Up
        fillUP();

        //setting up adapters
        qualADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, qualAL);
        examADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, examAL);
        course12ADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course12AL);
        courseugADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courseugAL);
        langADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, langAL);
        salaryADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, salaryAL);
        availADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, availAL);

        //setting up onSelect Listener
        qualSP.setAdapter(qualADP);
        langSP.setAdapter(langADP);
        qual2SP.setAdapter(qualADP);
        salarySP.setAdapter(salaryADP);
        availabilitySP.setAdapter(availADP);
        qualSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Qual = parent.getItemAtPosition(position).toString();
                if (Qual.equals("12Th Pass") || Qual.equals("10Th Pass")) {
                    examRL.setVisibility(View.VISIBLE);
                    examSP.setAdapter(examADP);
                    courseSP.setAdapter(course12ADP);
                } else if (!Qual.equals("   -   ")) {
                    examRL.setVisibility(View.GONE);
                    courseSP.setAdapter(courseugADP);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        yesBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesBT.setBackgroundResource(R.drawable.button_pink_round);
                noBT.setBackgroundResource(R.drawable.button_gray_round);
                toTV.setText("Present");
                toTV.setEnabled(false);
                jobET.setHint("Enter your Job Title");
                companyET.setHint("Enter your Company Name");
                workingRL.setVisibility(View.VISIBLE);
            }
        });
        noBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noBT.setBackgroundResource(R.drawable.button_pink_round);
                yesBT.setBackgroundResource(R.drawable.button_gray_round);
                toTV.setText("To");
                toTV.setEnabled(true);
                jobET.setHint("Enter your Last Job Title");
                companyET.setHint("Enter your Last Company Name");
                workingRL.setVisibility(View.VISIBLE);
            }
        });
        studentBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentBT.setBackgroundResource(R.drawable.button_pink_round);
                workinBT.setBackgroundResource(R.drawable.button_gray_round);
                studentLL.setVisibility(View.VISIBLE);
                workingLL.setVisibility(View.GONE);
            }
        });
        workinBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workinBT.setBackgroundResource(R.drawable.button_pink_round);
                studentBT.setBackgroundResource(R.drawable.button_gray_round);
                workingLL.setVisibility(View.VISIBLE);
                studentLL.setVisibility(View.GONE);
            }
        });
        fromTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker("from");
            }
        });
        toTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker("to");
            }
        });

        nextBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KeySkillsActivity.class));
            }
        });

        jobET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.scrollTo(0,scrollView.getBottom());
                return false;
            }
        });

    }

    private void fillUP() {
        qualAL = new ArrayList<>();
        qualAL.add("   -   ");
        qualAL.add("PhD");
        qualAL.add("PG");
        qualAL.add("UG");
        qualAL.add("Diploma");
        qualAL.add("12Th Pass");
        qualAL.add("10Th Pass");

        examAL = new ArrayList<>();
        examAL.add("   -   ");
        examAL.add("State Board");
        examAL.add("CBSE");
        examAL.add("ICSE");
        examAL.add("IGCSC");

        course12AL = new ArrayList<>();
        course12AL.add("   -   ");
        course12AL.add("Biology");
        course12AL.add("Computer");
        course12AL.add("Commerce");
        course12AL.add("Economics");

        courseugAL = new ArrayList<>();
        courseugAL.add("   -   ");
        courseugAL.add("CSE");
        courseugAL.add("IT");
        courseugAL.add("MECH");
        courseugAL.add("CIVIL");
        courseugAL.add("ECE");
        courseugAL.add("EEE");
        courseugAL.add("BME");

        langAL = new ArrayList<>();
        langAL.add("   -   ");
        langAL.add("Tamil");
        langAL.add("English");
        langAL.add("Malayalam");
        langAL.add("Telugu");
        langAL.add("Kannada");


        salaryAL = new ArrayList<>();
        salaryAL.add("   -   ");
        salaryAL.add("1000 - 10000");
        salaryAL.add("10001 - 25000");
        salaryAL.add("25001 - 50000");
        salaryAL.add("50001 - 100000");
        salaryAL.add("100001 - 500000");
        salaryAL.add("500001 - 1000000");
        salaryAL.add("1000001 - above");

        availAL = new ArrayList<>();
        availAL.add("   -   ");
        availAL.add("Yes");
        availAL.add("Need Time");

    }

    private void intiUI() {
        nextBT = findViewById(R.id.nextBT);
        qualSP = findViewById(R.id.qualSP);
        examSP = findViewById(R.id.examSP);
        courseSP = findViewById(R.id.courseSP);
        langSP = findViewById(R.id.langSP);
        qual2SP = findViewById(R.id.qual2SP);
        salarySP = findViewById(R.id.salarySP);
        availabilitySP = findViewById(R.id.availSP);
        fromTV = findViewById(R.id.fromTV);
        toTV = findViewById(R.id.toTV);
        jobET = findViewById(R.id.jobtitleTV);
        companyET = findViewById(R.id.companyTV);
        studentLL = findViewById(R.id.studentLL);
        workingLL = findViewById(R.id.workingLL);
        workingRL = findViewById(R.id.workingRL);
        studentBT = findViewById(R.id.studentBT);
        workinBT = findViewById(R.id.workingBT);
        yesBT = findViewById(R.id.yesBT);
        noBT = findViewById(R.id.noBT);
        scrollView =findViewById(R.id.scrollview);

        yearofpassET = findViewById(R.id.passingTV);
        marksET = findViewById(R.id.marksTV);
        examRL = findViewById(R.id.examRL);
    }
    private void datePicker(final String key) {


        MonthYearPickerDialog pickerDialog = new MonthYearPickerDialog();
        pickerDialog.setListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int i2) {
                value = month+"/"+year;
                if(key.equals("from")){
                    fromTV.setText(value);
                }else if (key.equals("to")){
                    toTV.setText(value);
                }
            }
        });
        pickerDialog.show(getSupportFragmentManager(), "MonthYearPickerDialog");
    }
}
