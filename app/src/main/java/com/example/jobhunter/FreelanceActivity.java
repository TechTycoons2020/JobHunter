package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.jobhunter.adapter.FreelanceJobAdapter;
import com.example.jobhunter.adapter.GovtJobAdapter;
import com.example.jobhunter.adapter.InternAdapter;
import com.example.jobhunter.models.FreelanceJobs;
import com.example.jobhunter.models.GovtJobs;

import java.util.ArrayList;

public class FreelanceActivity extends AppCompatActivity {
    //rec
    //array list
    //Adapter
    RecyclerView recyclerView;
    ArrayList<FreelanceJobs> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelance);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        initUI();

        jobs.add(new FreelanceJobs("Copy Writing","Write & content","6 days","Rs 2500","Expertise in Excel"));
        jobs.add(new FreelanceJobs("Graphic Designer","Design,Media & Architecture","6 days","Rs 18000","Expertise in Excel"));
        jobs.add(new FreelanceJobs("Translator","Translation & Languages","6 days","Rs 600","English Tutoring"));
        jobs.add(new FreelanceJobs("Data Entry","Data Entry & Admin","6 days","Rs 53500","Proficient Typing"));
        jobs.add(new FreelanceJobs("Android and ios app development","Mobile phones & computing","6 days","Rs 37500","Programming skills & Backend Computing"));
        recyclerView.setAdapter(new FreelanceJobAdapter(getApplicationContext(),jobs,FreelanceActivity.this));
        //Al populate
        //adater al set
        //rec adp set

    }

    private void initUI() {
        //rec
        //li la man
        //rec - li la vma
        recyclerView = findViewById(R.id.jobsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
}
