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

        tenders.add(new Tenders("Agro Product Tenders","India Tenders","15-feb-2020","200 billion","3821612","Tenders for availing short term loans of Rs.20000 crores with green shoe options."));
        tenders.add(new Tenders("Telecommunication Services / Equipments Tenders","India Tenders","20-Jan-2020","21.94 billion","37231363","Provision of 2g plus 4g based mobile services at mha identified tower locations in left wing extremism lwe-ii affected areas."));
        tenders.add(new Tenders("Shipping Tenders","India Tenders","17-Mar-2020","4.61 billion","38291435","Re construction of north jetty at naval base on EPC contract basis."));
        tenders.add(new Tenders("Civil Works Tenders","Bangladesh Tenders","17-Feb-2020","942.06 million","38266919","Construction of flexible pavement with earth work in road embankment and concrete slope protection at 46th km to 52nd km of sunamganj-madanpur-dirai-sulla-azmeriganj-habiganj road."));
        tenders.add(new Tenders("Roads Tenders","Multi State Tenders","27-Jan-2020 ","8.94 Billion","32980454","Construction of Four Lane Expressway ~ From Sindhrej Village to Vejalka Village of Ahmedabad District From Km 22.000 to Km 48.520 of Ahmedabad-dholera Greenfield Alignment Nh-751 on Ham Under Bmp in the State of Gujarat Pkg-ii."));
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
