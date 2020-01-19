package com.example.jobhunter.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobhunter.R;
import com.example.jobhunter.adapter.GovtJobAdapter;
import com.example.jobhunter.adapter.PrivateJobAdapter;
import com.example.jobhunter.models.GovtJobs;
import com.example.jobhunter.models.Jobs;

import java.util.ArrayList;

public class GovtJobsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<GovtJobs> jobs = new ArrayList<>();


    public GovtJobsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_govtjobs , container, false);
        initUI(view);

        //1 - yes or no question
        //2 - rating questions
        //3 - other answers
        jobs.add(new GovtJobs("General Manager","Tamilnad Mercantile Bank(TMB)","Tamil Nadu","01","24 Jan 2020","45 years and above","Engineering Graduate/MCA","Tamilnad Mercantile Bank(TMB) has invited applications for the General Manager,DGM and AGM posts.Interested candidates can apply for Tamilnad Mercantile Bank(TMB) Recruitment 2020 through the prescribed format on or before 24 January 2020."));
        jobs.add(new GovtJobs("Assistant Commandant","Indian Coast Guard ","Delhi","25","15 Feb 2020","20-25 years","Graduate","Indian Coast Guard Indian Coast Guard has invited applications for recruitment to the post of Assistant Commandant Posts.Interested and applicants can apply for the posts through online mode.The application process for Indian Coast Guard Assistant Commandant Jobs 2020 will start from 9 February 2020 and close on 15 February 2020.Candidates having Bachelors Degree in the concerned subject can apply for the posts."));
        jobs.add(new GovtJobs("Assistant Manager/Civil posts","Delhi Metro Rail Corporation(DMRC) ","Other Functional Area","35","04 Feb 2020","28 years","Graduate","The Delhi Metro Rail Corporation(DMRC) Ltd. has invited applications for the Assistant Manager/Civil posts.Interested applicants can apply for Delhi Metro Rail Corporation(DMRC) Recruitment 2020 through the prescribed format on or before 04 February 2020."));
        jobs.add(new GovtJobs("Senior Resident Posts","All Indian Institute of Medical Sciences(AIIMS)","Bhopal","78","12 Feb 2020","45 years ","Post Graduate/Graduate","All Indian Institue of Medical Sciences(AIIMS),Bhopal has invited applications for recruitment to the post of Senior Resident.Interested candidates can apply to the posts through the prescribed format on or before 12 February 2020."));
        jobs.add(new GovtJobs("Veterinary Assistant Surgeon","Animal Husbandry Department","Andhra Pradesh","78","31 Jan 2020","18-42 years","Graduate","Animal Husbandry Department,Government of Andhra Pradesh has invited applications for the recruitment of Veterinary Assistant Surgeon in crass 'A' of category of Andhra Pradesh Animal Husbandry services.Eligible candidates can apply for the post in the prescribed format on or before 31 January 2020."));
        recyclerView.setAdapter(new GovtJobAdapter(getContext(),jobs, getActivity()));

//        backIV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), GpsActivity.class));
//
//            }
//        });

        return view;
    }

    /*********************************************************/


    void initUI(View view){

        recyclerView = view.findViewById(R.id.jobsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

    }

}