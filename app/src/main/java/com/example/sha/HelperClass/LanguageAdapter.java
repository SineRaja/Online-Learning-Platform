package com.example.sha.HelperClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sha.R;
import com.example.sha.development.InternView;

import java.util.ArrayList;
import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {
    private Context context;
    private List<LanguageHelperClass> languageLocations;

    public LanguageAdapter(Context context, List<LanguageHelperClass> languageLocations){
        this.context = context;
        this.languageLocations = languageLocations;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_card_design,parent,false);
        LanguageAdapter.LanguageViewHolder languageViewHolder = new LanguageViewHolder(view);
        return languageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        LanguageHelperClass languageHelperClass = languageLocations.get(position);

        holder.image.setImageResource(languageHelperClass.getImage1());
        holder.title.setText(languageHelperClass.getTitle1());
        holder.author.setText(languageHelperClass.getAuthor1());
        holder.ratingBar.setRating(languageHelperClass.getRatingBar1());
        holder.cost.setText(languageHelperClass.getCost1());

        holder.cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent langIntent = new Intent(context, InternView.class);
                langIntent.putExtra("internTitle",languageLocations.get(position).getTitle1());
                langIntent.putExtra("internUrl",languageLocations.get(position).getUrl());
                context.startActivity(langIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageLocations.size();
    }

    public static class LanguageViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, author, cost;
        RatingBar ratingBar;
        CardView cardView2;

        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.skill_image);
            title =itemView.findViewById(R.id.skill_title);
            author =itemView.findViewById(R.id.skill_author);
            ratingBar =itemView.findViewById(R.id.skill_rate);
            cost =itemView.findViewById(R.id.skill_cost);
            cardView2 = itemView.findViewById(R.id.lang_cardView);

        }
    }
}
