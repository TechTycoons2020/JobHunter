package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText email , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //Intialization of UI
        initUI();
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //complete ur actions
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //complete ur actions
            }
        });

    }

    private void initUI() {
        email = findViewById(R.id.emaiET);
        password = findViewById(R.id.passwordET);
    }
}
