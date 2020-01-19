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
import com.example.jobhunter.models.FreelanceJobs;
import com.example.jobhunter.models.GovtJobs;

import java.util.ArrayList;

public class FreelanceJobAdapter extends RecyclerView.Adapter<FreelanceJobAdapter.SearchViewHolder> {

    private ArrayList<FreelanceJobs> jobdetails;
    private Context context;
    private Activity parent;

    public FreelanceJobAdapter(Context context, ArrayList<FreelanceJobs> jobdetails, Activity parent) {
        this.context = context;
        this.jobdetails = jobdetails;
        this.parent = parent;
    }

    @NonNull
    @Override
    public FreelanceJobAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.freelanceitems, parent, false);

        return new FreelanceJobAdapter.SearchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final FreelanceJobAdapter.SearchViewHolder holder, int position) {
        final FreelanceJobs model = (FreelanceJobs) jobdetails.get(position);

        holder.domain.setText(model.getDomain());
        holder.field.setText(model.getField());
        holder.applywithin.setText(model.getApplywithin());
        holder.salary.setText(model.getSalary());
        holder.skills.setText(model.getSkills());
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView domain , field , applywithin , salary , skills;

        public SearchViewHolder(View itemView) {
            super(itemView);

            domain = itemView.findViewById(R.id.freelancenameTV);
            field = itemView.findViewById(R.id.fieldTV);
            applywithin = itemView.findViewById(R.id.applyTV);
            salary= itemView.findViewById(R.id.salaryTV);
            skills= itemView.findViewById(R.id.skillsTV);

        }
    }
}
