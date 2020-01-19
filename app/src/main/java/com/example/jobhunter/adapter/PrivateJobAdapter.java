package com.example.jobhunter.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobhunter.JobExpandActivity;
import com.example.jobhunter.R;
import com.example.jobhunter.models.Jobs;
import com.example.jobhunter.utils.CommonUtils;

import java.util.ArrayList;

public class PrivateJobAdapter extends RecyclerView.Adapter<PrivateJobAdapter.SearchViewHolder> {

    private ArrayList<Jobs> jobdetails;
    private Context context;
    private Activity parent;

    public PrivateJobAdapter(Context context, ArrayList<Jobs> jobdetails, Activity parent) {
        this.context = context;
        this.jobdetails = jobdetails;
        this.parent = parent;
    }

    @NonNull
    @Override
    public PrivateJobAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.jobitems, parent, false);

        return new PrivateJobAdapter.SearchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final PrivateJobAdapter.SearchViewHolder holder, int position) {
        final Jobs model = (Jobs) jobdetails.get(position);

        holder.jobname.setText(model.getJobname());
        holder.company.setText(model.getCompanyname());
        holder.location.setText(model.getLocation());
        holder.salary.setText(model.getSalary());
        holder.experience.setText(model.getExperience());
        holder.apply.setText(model.getApplyby());
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JobExpandActivity.class);
                intent.putExtra(CommonUtils.Ijobname,model.getJobname());
                intent.putExtra(CommonUtils.Icompany,model.getCompanyname());
                intent.putExtra(CommonUtils.Ilocation,model.getLocation());
                intent.putExtra(CommonUtils.Iexper,model.getExperience());
                intent.putExtra(CommonUtils.Isalary,model.getSalary());
                intent.putExtra(CommonUtils.Iapplyby,model.getApplyby());
                intent.putExtra(CommonUtils.Ijobdesc,model.getJobdesc());
                intent.putExtra(CommonUtils.Icomdesc,model.getCompanydesc());
                intent.putExtra(CommonUtils.Icontact,model.getContact());
                intent.putExtra(CommonUtils.Ifield,model.getField());
                intent.putExtra(CommonUtils.Ilatitude,Double.toString(model.getGeotag().getLatitude()));
                intent.putExtra(CommonUtils.Ilongitude,Double.toString(model.getGeotag().getLongitude()));
                intent.putExtra(CommonUtils.Itype,"1");
                context.startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView jobname , company , location , salary , experience , apply;
        public LinearLayout base;

        public SearchViewHolder(View itemView) {
            super(itemView);

            jobname = itemView.findViewById(R.id.jobnameTV);
            company = itemView.findViewById(R.id.companyTV);
            location = itemView.findViewById(R.id.locationTV);
            salary= itemView.findViewById(R.id.salaryTV);
            experience= itemView.findViewById(R.id.experTV);
            apply= itemView.findViewById(R.id.applyTV);
            base = itemView.findViewById(R.id.baseLL);

        }
    }
}
