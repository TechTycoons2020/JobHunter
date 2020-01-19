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
import com.example.jobhunter.models.Tenders;
import com.example.jobhunter.utils.CommonUtils;

import java.util.ArrayList;

public class TenderAdapter extends RecyclerView.Adapter<TenderAdapter.SearchViewHolder> {

    private ArrayList<Tenders> jobdetails;
    private Context context;
    private Activity parent;

    public TenderAdapter(Context context, ArrayList<Tenders> jobdetails, Activity parent) {
        this.context = context;
        this.jobdetails = jobdetails;
        this.parent = parent;
    }

    @NonNull
    @Override
    public TenderAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.tenderitems, parent, false);

        return new TenderAdapter.SearchViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final TenderAdapter.SearchViewHolder holder, int position) {
        final Tenders model = (Tenders) jobdetails.get(position);

        holder.domain.setText(model.getSector());
        holder.location.setText(model.getLocation());
        holder.close.setText(model.getClosingdate());
        holder.value.setText(model.getTendervalue());
        holder.refer.setText(model.getRefno());
        holder.desc.setText(model.getTenderdesc());
    }

    @Override
    public int getItemCount() {
        return jobdetails.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        public TextView domain , location , close , value, refer, desc;

        public SearchViewHolder(View itemView) {
            super(itemView);

            domain = itemView.findViewById(R.id.sectorTV);
            location = itemView.findViewById(R.id.locationTV);
            close = itemView.findViewById(R.id.closeTV);
            value= itemView.findViewById(R.id.valueTV);
            refer= itemView.findViewById(R.id.refno);
            desc= itemView.findViewById(R.id.descTV);



        }
    }
}
