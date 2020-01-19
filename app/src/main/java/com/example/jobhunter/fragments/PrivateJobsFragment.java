package com.example.jobhunter.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobhunter.R;
import com.example.jobhunter.adapter.PrivateJobAdapter;
import com.example.jobhunter.models.Jobs;

import java.util.ArrayList;

public class PrivateJobsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Jobs> jobs = new ArrayList<>();


    public PrivateJobsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_privatejobs , container, false);
        initUI(view);

        //1 - yes or no question
        //2 - rating questions
        //3 - other answers
        jobs.add(new Jobs("App Developer","Google Inc","Chennai,Tamilnadu","2 years","Rs.75,000","15 Feb 2020","An Experienced App Developer","We Make Your Dreams Come True"));

        recyclerView.setAdapter(new PrivateJobAdapter(getContext(),jobs, getActivity()));

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