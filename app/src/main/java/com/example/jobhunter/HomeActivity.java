package com.example.jobhunter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jobhunter.utils.SharedPref;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout jobsRL, internshipRL, freelanceRL;
    ImageView dpIV, settingsIV , signoutIV;
    TextView usernameTV, useremailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //initializing UI elements
        initUI();

        //applying DP Image
        Picasso.get().load(SharedPref.getString(getApplicationContext(), "sp_image_url")).into(dpIV);
        usernameTV.setText(SharedPref.getString(getApplicationContext(), "sp_username"));
        useremailTV.setText(SharedPref.getString(getApplicationContext(), "sp_email"));

        //setting Onclick Listener
        jobsRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), JobsActivity.class));
            }
        });
        internshipRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InternshipActivity.class));
            }
        });
        freelanceRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FreelanceActivity.class));
            }
        });
        signoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignoutDialog();
            }
        });
        settingsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ResumeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initUI() {
        jobsRL = findViewById(R.id.jobsRL);
        internshipRL = findViewById(R.id.internshipRL);
        freelanceRL = findViewById(R.id.freelanceRL);
        dpIV = findViewById(R.id.dpIV);
        settingsIV = findViewById(R.id.settingsIV);
        usernameTV = findViewById(R.id.usernameTV);
        useremailTV = findViewById(R.id.useremailTV);
        signoutIV = findViewById(R.id.signoutIV);
    }

    //logout alert box Display
    void SignoutDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_logout, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);

        TextView noTV = dialogView.findViewById(R.id.noTV);
        TextView yesTV = dialogView.findViewById(R.id.yesTV);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();


        yesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.removeAll(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });
        noTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(startMain);
        finishAffinity();
        finish();
    }
}
