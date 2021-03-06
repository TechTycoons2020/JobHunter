package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.jobhunter.utils.SharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SharedPref.getBoolean(getApplicationContext(),"sp_loggedin") == true && SharedPref.getString(getApplicationContext(),"sp_where").equals("home"))
                {
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(SharedPref.getBoolean(getApplicationContext(),"sp_loggedin") == true && SharedPref.getString(getApplicationContext(),"sp_where").equals("tender"))
                {
                    Intent intent = new Intent(MainActivity.this,TenderMainActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        },1000);

    }
}
