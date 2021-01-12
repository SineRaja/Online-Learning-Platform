package com.example.sha.webdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sha.R;
import com.example.sha.internship.InternAdapter;
import com.example.sha.internship.InternHelperClass;
import com.example.sha.mainpage.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class WebDevelopment extends AppCompatActivity {

    RecyclerView webDevelopmentRecycle;
    RecyclerView.Adapter adapter;
    ImageView backToHome;
    List<InternHelperClass> internLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_development);

        webDevelopmentRecycle = findViewById(R.id.webDevelopment_Recycler);
        backToHome = findViewById(R.id.back_to_home);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backTohomeIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(backTohomeIntent);
            }
        });

        internLocations = new ArrayList<>();

        webDevelopmentRecycle.setHasFixedSize(true);
        webDevelopmentRecycle.setLayoutManager(new GridLayoutManager(this,1));

        internLocations.add(new InternHelperClass(R.drawable.html,"HTML","sine raja", 4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.css,"CSS","sine raja", 5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.bootstrap,"BootStrap","sine raja",  4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.javascript,"JavaScript","sine raja",  5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.php,"PHP","sine raja",  5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.nodejs,"node.js","sine raja",  5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.js,"JavaScript","sine raja",  5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.jsdot,".JS","sine raja",  5f,"\u20B94500"));


        InternAdapter adapter = new InternAdapter(this, internLocations);
        webDevelopmentRecycle.setAdapter(adapter);


    }
}