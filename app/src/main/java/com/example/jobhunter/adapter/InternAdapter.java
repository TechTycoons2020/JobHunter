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
import com.example.jobhunter.models.Interns;
import com.example.jobhunter.utils.CommonUtils;

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
        holder.baseLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JobExpandActivity.class);
                intent.putExtra(CommonUtils.Ijobname,model.getDomain());
                intent.putExtra(CommonUtils.Icompany,model.getCompanyname());
                intent.putExtra(CommonUtils.Ilocation,model.getLocation());
                intent.putExtra(CommonUtils.Iduration,model.getDuration());
                intent.putExtra(CommonUtils.Istart,model.getStartdate());
                intent.putExtra(CommonUtils.Istipend,model.getStipend());
                intent.putExtra(CommonUtils.Iapplyby,model.getApplyby());
                intent.putExtra(CommonUtils.Ijobdesc,model.getJobdesc());
                intent.putExtra(CommonUtils.Itype,"3");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView domain , companyname , location , duration , startdate, stipend, applyby;
        LinearLayout baseLL;

        public SearchViewHolder(View itemView) {
            super(itemView);

            domain = itemView.findViewById(R.id.domainTV);
            companyname= itemView.findViewById(R.id.companyTV);
            location = itemView.findViewById(R.id.locationTV);
            duration= itemView.findViewById(R.id.durationTV);
            startdate= itemView.findViewById(R.id.startTV);
            stipend=itemView.findViewById(R.id.stipendTV);
            applyby=itemView.findViewById(R.id.applyTV);
            baseLL = itemView.findViewById(R.id.baseLL);

        }
    }
}
