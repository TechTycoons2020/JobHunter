package com.example.jobhunter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jobhunter.adapter.TenderAdapter;
import com.example.jobhunter.models.Tenders;
import com.example.jobhunter.utils.SharedPref;

import java.util.ArrayList;

public class TenderMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Tenders> tenders = new ArrayList<>();
    ImageView logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        initUI();

        tenders.add(new Tenders("Agro Product Tenders","India Tenders","15-feb-2020","200 billion","3821612","Tenders for availing short term loans of Rs.20000 crores with green shoe options"));
        recyclerView.setAdapter(new TenderAdapter(getApplicationContext(),tenders,TenderMainActivity.this));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(TenderMainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
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
        });
    }
    private void initUI() {

        recyclerView = findViewById(R.id.jobsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        logout = findViewById(R.id.logoutTV);
    }
}
