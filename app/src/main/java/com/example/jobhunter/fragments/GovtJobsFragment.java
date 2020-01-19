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
        jobs.add(new GovtJobs("Computer Engineer","Ministry of Transport","Chennai,Tamilnadu","2 years","Rs.75,000","15 Feb 2020"));

        recyclerView.setAdapter(new GovtJobAdapter(getContext(),jobs, getActivity()));

        return view;
    }

    /*********************************************************/


    void initUI(View view){

        recyclerView = view.findViewById(R.id.jobsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

    }

}