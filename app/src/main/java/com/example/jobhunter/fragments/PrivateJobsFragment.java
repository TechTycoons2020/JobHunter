package com.example.jobhunter.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobhunter.R;
import com.example.jobhunter.adapter.PrivateJobAdapter;
import com.example.jobhunter.models.Jobs;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class PrivateJobsFragment extends Fragment {

    RecyclerView recyclerView;
    ImageView filterIV;
    TextView filterTV,clearTV;
    ArrayList<Jobs> job_det = new ArrayList<>();
    ArrayList<String> filters ;
    ArrayList<Jobs> result_jobs_det = new ArrayList<>();
    //key=1 - location
    //key=2 - job field
    //key=3 - salary
    int key=0;
    //firestore Initialization
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference prijobscolref = db.collection("privatejobs");
    PrivateJobAdapter adapter;


    public PrivateJobsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_privatejobs , container, false);
        initUI(view);
        fetchdata();
        clearTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (job_det.isEmpty()){
                    Toast.makeText(getActivity(), "Fetching Details...Please Wait...", Toast.LENGTH_SHORT).show();
                }
                else{
                    adapter = new PrivateJobAdapter(getContext(),job_det,getActivity());
                    recyclerView.setAdapter(adapter);
                }
            }
        });
        filterTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterdialogue(container);
            }
        });
        filterIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] gfg= filters.toArray();
                final String[] str = Arrays.copyOf(gfg,
                        gfg.length,
                        String[].class);

                AlertDialog.Builder builder =new AlertDialog.Builder(container.getRootView().getContext(), R.style.MyDialogTheme);
                builder.setTitle("Pick a color");
                builder.setCancelable(true);
                builder.setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (key==1){
                            filterLocation(container,str[which]);
                        }
                        else if(key==2){
                            filterField(container,str[which]);
                        }
                    }
                });
                builder.show();
            }
        });
//        recyclerView.setAdapter(new PrivateJobAdapter(getContext(),jobs, getActivity()));


        return view;
    }

    /*********************************************************/


    void initUI(View view){

        filterIV = view.findViewById(R.id.filterIV);
        filterIV.setVisibility(View.GONE);
        filterTV = view.findViewById(R.id.filterTV);
        clearTV = view.findViewById(R.id.clearTV);
        recyclerView = view.findViewById(R.id.jobsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    private void fetchdata() {
        prijobscolref.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            Jobs item = new Jobs();
                            item.setApplyby(document.getString("applyby"));
                            item.setCompanydesc(document.getString("comdesc"));
                            item.setCompanyname(document.getString("company"));
                            item.setExperience(document.getString("exper"));
                            item.setJobdesc(document.getString("jobdesc"));
                            item.setLocation(document.getString("location"));
                            item.setJobname(document.getString("jobname"));
                            item.setSalary(document.getString("salary"));
                            item.setContact(document.getString("contact"));
                            item.setGeotag(document.getGeoPoint("geotag"));
                            item.setField(document.getString("field"));

                            job_det.add(item);
                            adapter = new PrivateJobAdapter(getContext(),job_det,getActivity());
                            recyclerView.setAdapter(adapter);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Server Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void filterdialogue(ViewGroup par){
            final String[] colors = {"Location","Job Field","Salary"};
            AlertDialog.Builder builder =new AlertDialog.Builder(par.getRootView().getContext(), R.style.MyDialogTheme);
            builder.setTitle("FILTERS");
            builder.setCancelable(true);
            builder.setItems(colors, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        if (colors[which].equals("Location")){
                            filters = new ArrayList<>();
                            filters.add("Chennai");
                            filters.add("Hyderabad");
                            filters.add("Mumbai");
                            filters.add("Delhi");
                            filters.add("Noida");
                            filterIV.setVisibility(View.VISIBLE);
                            key=1;
                        }
                        else if (colors[which].equals("Job Field")){
                            filters = new ArrayList<>();
                            filters.add("Computer");
                            filters.add("Finance");
                            filters.add("Human Resource");
                            filters.add("Sales");
                            filterIV.setVisibility(View.VISIBLE);
                            key=2;
                        }
                        else if (colors[which].equals("Salary")){
                            filters = new ArrayList<>();
                            filters.add("below 15,000");
                            filters.add("15,001 - 30,000");
                            filters.add("30,001 - 50,000");
                            filters.add("50,001 - 1,00,000");
                            filters.add("1,00,001 - 5,00,000");
                            filters.add("5,00,001 - 10,00,000");
                            filters.add("10,00,001 and Above");
                            filterIV.setVisibility(View.VISIBLE);
                            key=3;
                        }
                }
            });
            builder.show();
    }
    public void filterLocation(ViewGroup par,String str){
        result_jobs_det.clear();
        if (str!=null) {
            for (int i = 0; i < job_det.size(); i++) {
                if (job_det.get(i).getLocation().toLowerCase().contains(str.toLowerCase())) {
                    result_jobs_det.add(job_det.get(i));
                }
            }
            adapter = new PrivateJobAdapter(getContext(),result_jobs_det,getActivity());
            recyclerView.setAdapter(adapter);
        }
        else {
            Toast.makeText(getActivity(), "Search Key Empty", Toast.LENGTH_SHORT).show();
        }

    }public void filterField(ViewGroup par,String str){
        result_jobs_det.clear();
        if (str!=null) {
            for (int i = 0; i < job_det.size(); i++) {
                if (job_det.get(i).getField().toLowerCase().contains(str.toLowerCase())) {
                    result_jobs_det.add(job_det.get(i));
                }
            }
            adapter = new PrivateJobAdapter(getContext(),result_jobs_det,getActivity());
            recyclerView.setAdapter(adapter);
        }
        else {
            Toast.makeText(getActivity(), "Search Key Empty", Toast.LENGTH_SHORT).show();
        }
    }
}