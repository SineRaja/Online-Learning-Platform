package com.example.sha.mainpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sha.HelperClass.IntershipAdapter;
import com.example.sha.R;
import com.example.sha.coding.CodingLanguages;
import com.example.sha.courses.Bigdata;
import com.example.sha.courses.CloudComputing;
import com.example.sha.courses.DigitalCourse;
import com.example.sha.courses.FullStackDeveloper;
import com.example.sha.courses.ProjectCourse;
import com.example.sha.development.AllDevelopment;
import com.example.sha.webdesign.WebDevelopment;


import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

   /* RecyclerView searchRecycleView;
    RecyclerView.Adapter adapter;
    ImageView backToHome;
    List<SearchHelperClass> searchLocations; */

    CardView bigData, cloudCardView, fullStackCardView, programingCardView, cyberCardView, mobileCardView, projectCardView, digitalCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        bigData = (CardView)rootView.findViewById(R.id.bigData_cardView);
        cloudCardView = (CardView)rootView.findViewById(R.id.cloud_cardView);
        fullStackCardView = (CardView)rootView.findViewById(R.id.fullStack_cardView);
        programingCardView = (CardView)rootView.findViewById(R.id.programming_CardView);
        cyberCardView = (CardView)rootView.findViewById(R.id.cyberSecurity_CardView);
        mobileCardView = (CardView)rootView.findViewById(R.id.mobile_CardView);
        projectCardView = (CardView)rootView.findViewById(R.id.project_cardView);
        digitalCardView = (CardView)rootView.findViewById(R.id.digital_cardView);


        bigData.setOnClickListener(view -> {
            Intent bigDataIntent = new Intent(getActivity(), Bigdata.class);
            startActivity(bigDataIntent);
        });

        cloudCardView.setOnClickListener(view -> {
            Intent cloudIntent = new Intent(getActivity(), CloudComputing.class);
            startActivity(cloudIntent);
        });

        fullStackCardView.setOnClickListener(view -> {
            Intent fullStackIntent = new Intent(getActivity(), WebDevelopment.class);
            startActivity(fullStackIntent);
        });

        programingCardView.setOnClickListener(view -> {
            Intent programIntent = new Intent(getActivity(),CodingLanguages.class);
            startActivity(programIntent);
        });

        projectCardView.setOnClickListener(view -> {
            Intent programIntent = new Intent(getActivity(), CodingLanguages.class);
            startActivity(programIntent);
        });

        cyberCardView.setOnClickListener(view -> {
            Intent cyberIntent = new Intent(getActivity(), FullStackDeveloper.class);
            startActivity(cyberIntent);
        });

        mobileCardView.setOnClickListener(view -> {
            Intent mobileIntent = new Intent(getActivity(), AllDevelopment.class);
            startActivity(mobileIntent);
        });

        projectCardView.setOnClickListener(view -> {
            Intent projectIntent = new Intent(getActivity(), ProjectCourse.class);
            startActivity(projectIntent);
        });

        digitalCardView.setOnClickListener(view -> {
            Intent digitalIntent = new Intent(getActivity(), DigitalCourse.class);
            startActivity(digitalIntent);
        });

        return rootView;

         /*  backToHome = rootView.findViewById(R.id.back_to_home_allFromSearch);
        backToHome.setOnClickListener(view -> {
            Intent backToHome = new Intent(getActivity(),HomeFragment.class);
            startActivity(backToHome);
        });

        searchRecycleView = rootView.findViewById(R.id.search_recyclerView);

        searchLocations = new ArrayList<>();

        searchRecycleView.setHasFixedSize(true);
        searchRecycleView.setLayoutManager(new GridLayoutManager(getContext(),2));


        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Big Data Analytics","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Full Stack Developer","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Programing","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Cloud Computing","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Cyber Security","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Mobile & Software Development","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Project Management","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Digital Marketing","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Sales Force","22 courses"));
        searchLocations.add(new SearchHelperClass(R.drawable.cc,"Business Productivity Tools","22 courses"));

        SearchAdapter adapter = new SearchAdapter(getContext(),searchLocations);
        searchRecycleView.setAdapter(adapter);

          */

     }
}
