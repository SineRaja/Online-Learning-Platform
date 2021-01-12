package com.example.sha.mainpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.sha.HelperClass.InternshipHelperClass;
import com.example.sha.HelperClass.IntershipAdapter;
import com.example.sha.HelperClass.LanguageAdapter;
import com.example.sha.HelperClass.LanguageHelperClass;
import com.example.sha.R;
import com.example.sha.coding.CodingLanguages;
import com.example.sha.development.AllDevelopment;
import com.example.sha.internship.InternshipDetials;
import com.example.sha.webdesign.WebDevelopment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView internshipRecycler;
    RecyclerView languageRecycler;
    RecyclerView webRecycler;
    RecyclerView catgoriesRecycle;
    RecyclerView.Adapter adapter;

    List<InternshipHelperClass> internshipLocations;
    List<LanguageHelperClass> languageLocations;

    TextView textInternViewAll, textCodingViewAll, webViewAll, developViewAll;

    ViewFlipper viewFlipper;
    int[] images = {R.drawable.first, R.drawable.second,R.drawable.third,R.drawable.fourth};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false);

        viewFlipper = rootView.findViewById(R.id.v_flipper1);

        for (int image : images) {
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(image);
        }

        textInternViewAll = (TextView)rootView.findViewById(R.id.intern_viewAll);
        textInternViewAll.setOnClickListener(view -> {
            Intent myIntent = new Intent(getActivity(), InternshipDetials.class);
            startActivity(myIntent);
        });

        textCodingViewAll = (TextView)rootView.findViewById(R.id.coding_viewall);
        textCodingViewAll.setOnClickListener(view -> {
            Intent codIntent = new Intent(getActivity(), CodingLanguages.class);
            startActivity(codIntent);
        });

        webViewAll = (TextView)rootView.findViewById(R.id.web_viewall);
        webViewAll.setOnClickListener(view -> {
            Intent webIntent = new Intent(getActivity(), WebDevelopment.class);
            startActivity(webIntent);
        });

        developViewAll = (TextView)rootView.findViewById(R.id.alldev_viewAll);
        developViewAll.setOnClickListener(view -> {
            Intent devIntent = new Intent(getActivity(), AllDevelopment.class);
            startActivity(devIntent);
        });

        internshipRecycler = (RecyclerView)rootView.findViewById(R.id.intership_recycler);

        internshipRecycler();

        languageRecycler = (RecyclerView)rootView.findViewById(R.id.languages_recycler);

        languageRecycler();

        webRecycler = (RecyclerView)rootView.findViewById(R.id.web_recycler);

        webRecycler();

        catgoriesRecycle = (RecyclerView)rootView.findViewById(R.id.categories_recycler);

        catgoriesRecycle();

        return rootView;
    }

    private void catgoriesRecycle() {
        catgoriesRecycle.setHasFixedSize(true);
        catgoriesRecycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        ArrayList<LanguageHelperClass> languageLocations = new ArrayList<>();

        languageLocations.add(new LanguageHelperClass(R.drawable.angular,"C Language","sine raja", 3.5f,"2500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.linuxpen,"C Language","sine raja", 5f,"2500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.net,"C Language","sine raja",  4.5f,"2500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.ubuntu,"C Language","sine raja",  4f,"2500","https://rajafirstpage.ccbp.tech/"));

        adapter = new LanguageAdapter(getActivity(),languageLocations);
        catgoriesRecycle.setAdapter(adapter);

    }

    private void webRecycler() {
        webRecycler.setHasFixedSize(true);
        webRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        internshipLocations = new ArrayList<>();

        internshipLocations.add(new InternshipHelperClass(R.drawable.html,"HTML","Price : \u20B9450/-","Basha","https://rajafirstpage.ccbp.tech/",4.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.css,"CSS","Price : \u20B9450/-","Ram","https://rajafirstpage.ccbp.tech/",4.8f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.javascript,"javaScript","Price : \u20B9450/-","RRR","https://rajafirstpage.ccbp.tech/",4.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.bootstrap,"BootStrap","Price : \u20B9450/-","IIT","https://rajafirstpage.ccbp.tech/",4.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.js,".JS","Price : \u20B9450/-","Rani","https://rajafirstpage.ccbp.tech/",4.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.nodejs,"nodeJS","Price : \u20B9450/-","Raja ","https://rajafirstpage.ccbp.tech/",4.0f));

        adapter = new IntershipAdapter(getActivity(),internshipLocations);
        webRecycler.setAdapter(adapter);
    }

    private void languageRecycler() {
        //this is for internship
        languageRecycler.setHasFixedSize(true);
        languageRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

       languageLocations = new ArrayList<>();

        languageLocations.add(new LanguageHelperClass(R.drawable.machineintern,"machine learning","sine raja", 3.5f,"\u20B94500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.artificialintern,"artificial intelligence","sine raja", 5f,"\u20B94500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.internetintern,"internet of things","sine raja",  4.5f,"\u20B94500","https://rajafirstpage.ccbp.tech/"));
        languageLocations.add(new LanguageHelperClass(R.drawable.androidintern,"android app development","sine raja",  4f,"\u20B94500","https://rajafirstpage.ccbp.tech/"));

        adapter = new LanguageAdapter(getActivity(),languageLocations);
        languageRecycler.setAdapter(adapter);

    }

    private void internshipRecycler() {
        //programing languages

        internshipRecycler.setHasFixedSize(true);
        internshipRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        internshipLocations = new ArrayList<>();

        internshipLocations.add(new InternshipHelperClass(R.drawable.cc,"C Programming","\u20B9 free ","Sine Raja","https://rajafirstpage.ccbp.tech/",3.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.java,"Java Programming","\u20B9 free","Sine raja","https://rajafirstpage.ccbp.tech/",3.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.python,"Python Programming","Price : free","Raja","https://rajafirstpage.ccbp.tech/",4.5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.ccc,"c++ Programming","\u20B9 free","Basha","https://rajafirstpage.ccbp.tech/",5f));
        internshipLocations.add(new InternshipHelperClass(R.drawable.ruby,"Ruby","\u20B9 free","Basha","https://rajafirstpage.ccbp.tech/",5f));

        adapter = new IntershipAdapter(getActivity(),internshipLocations);
        internshipRecycler.setAdapter(adapter);

        /*IntershipAdapter adapter = new IntershipAdapter(getActivity(),internshipLocations);
        webRecycler.setAdapter(adapter);*/

    }


    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
    }


}