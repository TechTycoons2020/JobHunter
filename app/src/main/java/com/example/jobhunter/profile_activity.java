package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class profile_activity extends AppCompatActivity {

    Button studentBT,workingBT;
    EditText nameET,contactET,addressET,mailET,passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        initUI();

        studentBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StatusActivity.class));
            }
        });
        workingBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WorkerActivity.class));
            }
        });

    }

    private void initUI() {
        studentBT = findViewById(R.id.studentBT);
        workingBT = findViewById(R.id.workingBT);
        nameET = findViewById(R.id.nameTV);
        contactET = findViewById(R.id.mobileTV);
        addressET = findViewById(R.id.locationTV);
        mailET=findViewById(R.id.emailTV);
        passwordET = findViewById(R.id.passwordTV);
    }
}
