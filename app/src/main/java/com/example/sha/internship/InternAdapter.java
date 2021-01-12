package com.example.sha.internship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sha.R;

import java.util.ArrayList;
import java.util.List;

public class InternAdapter extends RecyclerView.Adapter<InternAdapter.InternViewHolder>{
    private Context context;
    private List<InternHelperClass> internLocations;

    public InternAdapter(Context context, List<InternHelperClass> internLocations) {
        this.context = context;
       this.internLocations = internLocations;
    }

    //public InternAdapter(InternshipDetials internshipDetials, List<InternHelperClass> internLocations) {
    //    this.internLocations = internLocations;
    //}

    @NonNull
    @Override
    public InternViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.intern_detail_card,parent,false);
        InternAdapter.InternViewHolder internViewHolder = new InternViewHolder(view);
        return internViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InternViewHolder holder,final int position) {
        InternHelperClass internHelperClass = internLocations.get(position);

        holder.internImage.setImageResource(internHelperClass.getInternOfImage());
        holder.internTitle.setText(internHelperClass.getInternOfTitle());
        holder.internAuthor.setText(internHelperClass.getInternOfAuthor());
        holder.internRating.setRating(internHelperClass.getInternRating());
        holder.internCost.setText(internHelperClass.getInternOfCost());

    }

    @Override
    public int getItemCount() {
        return internLocations.size();
    }

    public static class InternViewHolder extends RecyclerView.ViewHolder{

        ImageView internImage;
        TextView internTitle, internAuthor, internCost;
        RatingBar internRating;

        public InternViewHolder(@NonNull View itemView) {
            super(itemView);

            internImage = itemView.findViewById(R.id.intern_image);
            internTitle = itemView.findViewById(R.id.intern_title);
            internAuthor = itemView.findViewById(R.id.intern_author);
            internRating = itemView.findViewById(R.id.intern_rating);
            internCost = itemView.findViewById(R.id.intern_cost);
        }
    }
}
