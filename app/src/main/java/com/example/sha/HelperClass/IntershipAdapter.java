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
import com.example.sha.coding.CodingView;
import com.example.sha.mainpage.HomeFragment;

import java.util.List;

public class IntershipAdapter extends RecyclerView.Adapter<IntershipAdapter.InternshipViewHolder> {

    private Context context;
    private List<InternshipHelperClass> internshipLocations;

   /* public IntershipAdapter(Context context, ArrayList<InternshipHelperClass> internshipLocations) {

    }*/

    public IntershipAdapter(Context context, List<InternshipHelperClass> internshipLocations) {
        this.context = context;
        this.internshipLocations = internshipLocations;

    }

    @NonNull
    @Override
    public InternshipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.internship_card_design,parent,false);
        IntershipAdapter.InternshipViewHolder internshipViewHolder =new InternshipViewHolder(view);
        return internshipViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InternshipViewHolder holder, int position) {

        InternshipHelperClass internshipHelperClass = internshipLocations.get(position);

        holder.image.setImageResource(internshipHelperClass.getImage());
        holder.title.setText(internshipHelperClass.getTitle());
        holder.cost.setText(internshipHelperClass.getCost());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent codingIntent = new Intent(context, CodingView.class);
                codingIntent.putExtra("CodingTitle", internshipLocations.get(position).getTitle());
                codingIntent.putExtra("codingLink",internshipLocations.get(position).getUrl());
                codingIntent.putExtra("codingRating",internshipLocations.get(position).getRatingBarIntern());
                codingIntent.putExtra("codingAuthor",internshipLocations.get(position).getAuthorIntern());
                codingIntent.putExtra("codingImage",internshipLocations.get(position).getImage());
                context.startActivity(codingIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return internshipLocations.size();
    }

    public static class InternshipViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, author, cost;
        RatingBar ratingBar;
        CardView cardView;

        public InternshipViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.intership_image);
            title = itemView.findViewById(R.id.internship_title);
            cost = itemView.findViewById(R.id.internship_cost);
            author = itemView.findViewById(R.id.internshipCard_author);
            ratingBar = itemView.findViewById(R.id.internshipCard_rate);
            cardView = itemView.findViewById(R.id.intership_cardview);

        }
    }
}
