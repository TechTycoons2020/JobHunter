package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {

    Button nextBT;
    Spinner qualSP, examSP, courseSP, langSP;
    EditText yearofpassET, marksET;
    RelativeLayout examRL;

    //Spinner populations
    ArrayAdapter<String> qualADP , examADP , course12ADP ,courseugADP, langADP;
    ArrayList<String> qualAL , examAL , course12AL , courseugAL , langAL;

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

        nextBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KeySkillsActivity.class));
            }
        });

        //setting up adapters
         qualADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, qualAL);
         examADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, examAL);
         course12ADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course12AL);
         courseugADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courseugAL);
         langADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, langAL);

         //setting up onSelect Listener
        qualSP.setAdapter(qualADP);
        langSP.setAdapter(langADP);
        qualSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Qual = parent.getItemAtPosition(position).toString();
                if (Qual.equals("12Th Pass") ||Qual.equals("10Th Pass") ){
                    examRL.setVisibility(View.VISIBLE);
                    examSP.setAdapter(examADP);
                    courseSP.setAdapter(course12ADP);
                }
                else if(!Qual.equals("   -   ")) {
                    examRL.setVisibility(View.GONE);
                    courseSP.setAdapter(courseugADP);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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

    }

    private void intiUI() {
        nextBT = findViewById(R.id.nextBT);
        qualSP = findViewById(R.id.qualSP);
        examSP = findViewById(R.id.examSP);
        courseSP= findViewById(R.id.courseSP);
        langSP= findViewById(R.id.langSP);
        yearofpassET= findViewById(R.id.passingTV);
        marksET= findViewById(R.id.marksTV);
        examRL = findViewById(R.id.examRL);
    }
}
