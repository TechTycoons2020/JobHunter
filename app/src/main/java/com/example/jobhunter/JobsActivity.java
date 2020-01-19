package com.example.jobhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.jobhunter.adapter.ViewPagerAdapter;
import com.example.jobhunter.fragments.GovtJobsFragment;
import com.example.jobhunter.fragments.PrivateJobsFragment;
import com.example.jobhunter.utils.SharedPref;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class JobsActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PrivateJobsFragment(), "Private Jobs");
        adapter.addFragment(new GovtJobsFragment(), "Govt Jobs");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }
}
