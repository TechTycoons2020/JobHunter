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
import com.example.jobhunter.models.Interns;

import java.util.ArrayList;

public class InternAdapter extends RecyclerView.Adapter<InternAdapter.SearchViewHolder> {

    private ArrayList<Interns> jobdetails;
    private Context context;
    private Activity parent;

    public InternAdapter(Context context, ArrayList<Interns> jobdetails, Activity parent) {
        this.context = context;
        this.jobdetails = jobdetails;
        this.parent = parent;
    }

    @NonNull
    @Override
    public InternAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.internshipitems, parent, false);

        return new InternAdapter.SearchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final InternAdapter.SearchViewHolder holder, int position) {
        final Interns model = (Interns) jobdetails.get(position);

        holder.domain.setText(model.getDomain());
        holder.companyname.setText(model.getCompanyname());
        holder.location.setText(model.getLocation());
        holder.duration.setText(model.getDuration());
        holder.startdate.setText(model.getStartdate());
        holder.stipend.setText(model.getStipend());
        holder.applyby.setText(model.getApplyby());
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView domain , companyname , location , duration , startdate, stipend, applyby;

        public SearchViewHolder(View itemView) {
            super(itemView);

            domain = itemView.findViewById(R.id.domainTV);
            companyname= itemView.findViewById(R.id.companyTV);
            location = itemView.findViewById(R.id.locationTV);
            duration= itemView.findViewById(R.id.durationTV);
            startdate= itemView.findViewById(R.id.startTV);
            stipend=itemView.findViewById(R.id.stipendTV);
            applyby=itemView.findViewById(R.id.applyTV);

        }
    }
}
