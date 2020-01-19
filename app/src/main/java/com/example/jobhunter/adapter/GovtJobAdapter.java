package com.example.jobhunter.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobhunter.R;
import com.example.jobhunter.models.GovtJobs;

import java.util.ArrayList;

public class GovtJobAdapter extends RecyclerView.Adapter<GovtJobAdapter.SearchViewHolder> {

    private ArrayList<GovtJobs> jobdetails;
    private Context context;
    private Activity parent;

    public GovtJobAdapter(Context context, ArrayList<GovtJobs> jobdetails, Activity parent) {
        this.context = context;
        this.jobdetails = jobdetails;
        this.parent = parent;
    }

    @NonNull
    @Override
    public GovtJobAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.govtjobitems, parent, false);

        return new GovtJobAdapter.SearchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final GovtJobAdapter.SearchViewHolder holder, int position) {
        final GovtJobs model = (GovtJobs) jobdetails.get(position);

        holder.jobname.setText(model.getJobname());
        holder.company.setText(model.getCompanyname());
        holder.location.setText(model.getLocation());
        holder.vacancy.setText(model.getVacancies());
        holder.qualification.setText(model.getQualifications());
        holder.apply.setText(model.getApplyby());
        holder.agelimit.setText(model.getAge());
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView jobname , company , location , vacancy , qualification , apply , agelimit;

        public SearchViewHolder(View itemView) {
            super(itemView);

            jobname = itemView.findViewById(R.id.jobnameTV);
            company = itemView.findViewById(R.id.companyTV);
            location = itemView.findViewById(R.id.locationTV);
            vacancy= itemView.findViewById(R.id.vacancyTV);
            qualification= itemView.findViewById(R.id.qualTV);
            apply= itemView.findViewById(R.id.applyTV);
            agelimit=itemView.findViewById(R.id.ageTV);

        }
    }
}
