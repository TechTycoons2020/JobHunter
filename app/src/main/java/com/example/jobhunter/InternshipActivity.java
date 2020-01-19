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

        jobs.add(new Interns("Digital Marketing","Nana Enterprise Private Limited","Work from Home","1 month","Immediately","Rs 10000","3 Feb 2020","Working on Photoshop editing and content creation for product pictures for e-commerce websites.Generating creatives for active engagement on social media platforms."));
        jobs.add(new Interns("Campus Ambassador","Srijan,IIT(ISM)","Dhanbad","3 weeks","Immediately","Performance based","30 Jan 2020","This campus ambassador is an accredited representative of Srijan in his/her institute and is the cardinal link between the two.As a campus ambassador you shall be a correspondent of Srijan and shall work to ensure the maximum number of participants at Srijan from your college."));
        jobs.add(new Interns("Graphic Design","myHQ","Delhi","Immediately","5 months","Rs 15000","3 Feb 2020","Ideate and create fresh innovative designs for offline and digital collaterals.Strategize and develop the visual imagery of myHQ so that the brand is perceived as millenial,quirky,trendy and trust-worthy.Participate & brainstorm in creative meetings to advise with creatives,&visual communication."));
        jobs.add(new Interns("Animation","Trending News Buzz","Work from Home","Immediately","6 months","Rs 3000-6000","3 Feb 2020","Make 2-3 minutes animated videos like kids stories.Make picture in picture videos.Make at least 1 viseo in 2 days"));
        jobs.add(new Interns("Human Resources","Big Feather","Mumbai","6 months","Immediately","Rs 5000","3 Feb 2020","Updating company databases by inputting new employee contact information and employment details.Screening potential employee's resumes and application forms to identify suitable candidates to fill company job vacancies.Scheduling and confirming interviews with candidates.Posting job advertisement to job boards and social media platforms."));
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
