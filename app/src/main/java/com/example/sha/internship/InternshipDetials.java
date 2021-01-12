package com.example.sha.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.sha.R;
import com.example.sha.mainpage.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class InternshipDetials extends AppCompatActivity {

    RecyclerView internRecycle;
    RecyclerView.Adapter adapter;
    ImageView backToHome;
    ViewFlipper intern_viewFlipper;

    List<InternHelperClass> internLocations;

    int internship[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship_detials);

        backToHome = findViewById(R.id.back_to_home_intern);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(backToHome);
            }
        });

        intern_viewFlipper = findViewById(R.id.intern_flipper);

        for(int i=0; i<internship.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(internship[i]);
        }

        internRecycle = findViewById(R.id.internship_program);

        internLocations = new ArrayList<>();

        internRecycle.setHasFixedSize(true);
        internRecycle.setLayoutManager(new GridLayoutManager(this,1));

        internLocations.add(new InternHelperClass(R.drawable.machineintern,"Machine Learning","sine raja", 4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.artificialintern,"artificial intelligence","sine raja", 5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.internetintern,"internet of things","sine raja",  4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.androidintern,"android app development","sine raja",  5f,"\u20B94500"));


        InternAdapter adapter = new InternAdapter(this, internLocations);
        internRecycle.setAdapter(adapter);
    }



    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(this);
        image.setBackgroundResource(res);
        intern_viewFlipper.addView(image);
        intern_viewFlipper.setFlipInterval(2500);
        intern_viewFlipper.setAutoStart(true);

    }
}