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
import com.example.jobhunter.models.Interns;

import java.util.ArrayList;

public class InternshipActivity extends AppCompatActivity {
    //rec
    //array list
    //Adapter
    RecyclerView recyclerView;
    ArrayList<Interns> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        initUI();

        jobs.add(new Interns("Digital Marketing","Nana Enterprise Private Limited","Work from Home","Immediately","1 month","Rs 10000","3 Feb 2020"));
        recyclerView.setAdapter(new InternAdapter(getApplicationContext(),jobs,InternshipActivity.this));
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
