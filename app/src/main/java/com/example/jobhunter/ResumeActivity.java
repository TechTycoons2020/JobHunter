package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ResumeActivity extends AppCompatActivity {
    EditText name,domain,address,email,expertise1,
            expertise2,expertise3,expertise4,companyname,companyloc,
            jobtitle,exp1,exp2,clgname,clgloc,degree,clgdur,clgpercent,
            clgachieve,schoolname,schoolloc,qual,schooldur,schoolpercent,
            schoolachieve,ach1,ach2,ach3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);


        initUI();
    }
    private void initUI() {
        name = findViewById(R.id.nameET);
        domain = findViewById(R.id.domainET);
        address = findViewById(R.id.addressET);
        email = findViewById(R.id.emailET);
        expertise1 = findViewById(R.id.expertise1ET);
        expertise2 = findViewById(R.id.expertise2ET);
        expertise3 = findViewById(R.id.expertise3ET);
        expertise4 = findViewById(R.id.expertise4ET);
        companyname = findViewById(R.id.expcompanyET);
        companyloc = findViewById(R.id.explocationET);
        jobtitle = findViewById(R.id.expjobtitleET);
        exp1 = findViewById(R.id.exp1ET);
        exp2 = findViewById(R.id.exp2ET);
        clgname = findViewById(R.id.clgET);
        clgloc = findViewById(R.id.clglocationET);
        degree = findViewById(R.id.degreeET);
        clgdur = findViewById(R.id.degdurationET);
        clgpercent = findViewById(R.id.clgpercentET);
        clgachieve = findViewById(R.id.clgachievementET);
        schoolname = findViewById(R.id.schoolnameET);
        schoolloc = findViewById(R.id.schoollocET);
        qual = findViewById(R.id.qualET);
        schooldur = findViewById(R.id.schooldurET);
        schoolpercent = findViewById(R.id.schoolpercentET);
        schoolachieve = findViewById(R.id.schoolachievementET);
        ach1 = findViewById(R.id.achievement1ET);
        ach2 = findViewById(R.id.achievement2ET);
        ach3 = findViewById(R.id.achievement3ET);
    }
}
