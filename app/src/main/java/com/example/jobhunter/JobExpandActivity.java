package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobhunter.utils.CommonUtils;

public class JobExpandActivity extends AppCompatActivity {
    TextView jobnameTV , companyTV, locationTV,qualTV,
            fieldTV,startTV,experTV,salaryTV,skillsTV,
            durationTV,stipendTV,vacancyTV,agelimitTV,applybyTV,
            jobdescTV,compdescTV;
    LinearLayout qualLL,fieldLL,startLL,experLL,salaryLL,skillLL,
            durationLL,stipendLL,vacancyLL,
            agelimitLL,applybyLL,jobdescLL,compdescLL;
    ImageView gpsIV,phoneIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_expand);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        intiUI();

        final Intent intent = getIntent();
        String keyType = intent.getStringExtra(CommonUtils.Itype);
        if (keyType.equals("1")){
            experLL.setVisibility(View.VISIBLE);
            salaryLL.setVisibility(View.VISIBLE);
            applybyLL.setVisibility(View.VISIBLE);
            jobdescLL.setVisibility(View.VISIBLE);
            compdescLL.setVisibility(View.VISIBLE);
            phoneIV.setVisibility(View.VISIBLE);
            phoneIV.setEnabled(true);
            fieldLL.setVisibility(View.VISIBLE);
            gpsIV.setVisibility(View.VISIBLE);
            gpsIV.setEnabled(true);

            jobnameTV.setText(intent.getStringExtra(CommonUtils.Ijobname));
            companyTV.setText(intent.getStringExtra(CommonUtils.Icompany));
            locationTV.setText(intent.getStringExtra(CommonUtils.Ilocation));
            experTV.setText(intent.getStringExtra(CommonUtils.Iexper));
            salaryTV.setText(intent.getStringExtra(CommonUtils.Isalary));
            applybyTV.setText(intent.getStringExtra(CommonUtils.Iapplyby));
            jobdescTV.setText(intent.getStringExtra(CommonUtils.Ijobdesc));
            compdescTV.setText(intent.getStringExtra(CommonUtils.Icomdesc));
            fieldTV.setText(intent.getStringExtra(CommonUtils.Ijobname));

            //Onclick listener for making calls
            phoneIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callintent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", intent.getStringExtra(CommonUtils.Icontact), null));

                    if (ActivityCompat.checkSelfPermission(JobExpandActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(JobExpandActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                1);
                        return;
                    }
                    callintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callintent);
                }
            });
            //Onclick listener for navigating to schools
            gpsIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ContextCompat.checkSelfPermission(JobExpandActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(JobExpandActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(JobExpandActivity.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                                1);

                    }
                    else {
                        if (!CommonUtils.alerter(getApplicationContext())) {
                            CommonUtils.openCustomBrowser(getApplicationContext(), "https://www.google.com/maps/place/" +  intent.getStringExtra(CommonUtils.Ilatitude) + "," + intent.getStringExtra(CommonUtils.Ilongitude));
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Check Network connection", Toast.LENGTH_SHORT).show();
                        }

                    }}
            });
            Log.i("testttttt", "onCreate:"+intent.getStringExtra(CommonUtils.Ilatitude)+" "+intent.getStringExtra(CommonUtils.Ilongitude)+"...");
        }


    }

    private void intiUI() {
        jobnameTV = findViewById(R.id.jobnameTV);
        companyTV = findViewById(R.id.companyTV);
        locationTV = findViewById(R.id.locationTV);
        qualTV= findViewById(R.id.qualTV);
        fieldTV= findViewById(R.id.fieldTV);
        startTV= findViewById(R.id.startTV);
        experTV = findViewById(R.id.experTV);
        salaryTV= findViewById(R.id.salaryTV);
        skillsTV= findViewById(R.id.skillsTV);
        durationTV= findViewById(R.id.durationTV);
        stipendTV= findViewById(R.id.stipendTV);
        vacancyTV= findViewById(R.id.vacancyTV);
        agelimitTV= findViewById(R.id.agelimitTV);
        applybyTV= findViewById(R.id.applyTV);
        jobdescTV= findViewById(R.id.jobdescTV);
        compdescTV= findViewById(R.id.comdescTV);

        qualLL = findViewById(R.id.qualLL);
        qualLL.setVisibility(View.GONE);
        fieldLL= findViewById(R.id.fieldLL);
        fieldLL.setVisibility(View.GONE);
        startLL= findViewById(R.id.startLL);
        startLL.setVisibility(View.GONE);
        experLL= findViewById(R.id.experLL);
        experLL.setVisibility(View.GONE);
        salaryLL= findViewById(R.id.salaryLL);
        salaryLL.setVisibility(View.GONE);
        skillLL= findViewById(R.id.skillLL);
        skillLL.setVisibility(View.GONE);
        durationLL= findViewById(R.id.durationLL);
        durationLL.setVisibility(View.GONE);
        stipendLL= findViewById(R.id.stipendLL);
        stipendLL.setVisibility(View.GONE);
        vacancyLL= findViewById(R.id.vacancyLL);
        vacancyLL.setVisibility(View.GONE);
        agelimitLL= findViewById(R.id.agelimitLL);
        agelimitLL.setVisibility(View.GONE);
        applybyLL= findViewById(R.id.applybyLL);
        applybyLL.setVisibility(View.GONE);
        jobdescLL= findViewById(R.id.jobdescLL);
        jobdescLL.setVisibility(View.GONE);
        compdescLL= findViewById(R.id.compdescLL);
        compdescLL.setVisibility(View.GONE);

        phoneIV=findViewById(R.id.phoneIV);
        phoneIV.setVisibility(View.GONE);
        gpsIV=findViewById(R.id.gpsIV);
        gpsIV.setVisibility(View.GONE);

    }


}
