package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobhunter.utils.MonthYearPickerDialog;
import com.whiteelephant.monthpicker.MonthPickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class WorkerActivity extends AppCompatActivity {
    Button nextBT , yesBT ,noBT;
    Spinner qualSP , salarySP , availabilitySP;
    TextView fromTV , toTV;
    EditText jobET,companyET;
    RelativeLayout workingRL;
    String value="";

    //Spinner populations
    ArrayAdapter<String> qualADP ,salaryADP, availADP;
    ArrayList<String> qualAL ,salaryAL,availAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        intiUI();

        fillUP();

        //setting up adapters
        qualADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, qualAL);
        salaryADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, salaryAL);
        availADP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, availAL);

        qualSP.setAdapter(qualADP);
        salarySP.setAdapter(salaryADP);
        availabilitySP.setAdapter(availADP);

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
        fromTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromTV.setText(datePicker());
            }
        });
        toTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTV.setText(datePicker());
            }
        });

        nextBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),KeySkillsActivity.class));
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
        salarySP = findViewById(R.id.salarySP);
        availabilitySP = findViewById(R.id.availSP);
        yesBT = findViewById(R.id.yesBT);
        noBT = findViewById(R.id.noBT);
        fromTV = findViewById(R.id.fromTV);
        toTV = findViewById(R.id.toTV);
        jobET =findViewById(R.id.jobtitleTV);
        companyET =findViewById(R.id.companyTV);
        workingRL = findViewById(R.id.workingRL);


    }
    private String datePicker() {


        MonthYearPickerDialog pickerDialog = new MonthYearPickerDialog();
        pickerDialog.setListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int i2) {
                value = year+"/"+month;
            }
        });
        pickerDialog.show(getSupportFragmentManager(), "MonthYearPickerDialog");
        return value;
    }

}
