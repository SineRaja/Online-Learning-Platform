package com.example.sha.coding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sha.R;
import com.example.sha.internship.InternAdapter;
import com.example.sha.internship.InternHelperClass;
import com.example.sha.mainpage.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class CodingLanguages extends AppCompatActivity {

    RecyclerView codingRecycle;
    RecyclerView.Adapter adapter;
    ImageView backToHome;
    List<InternHelperClass> internLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding_languages);

        backToHome = findViewById(R.id.back_to_home_coding);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent codingToHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(codingToHome);
            }
        });

        codingRecycle = findViewById(R.id.coding_program);

        internLocations = new ArrayList<>();

        codingRecycle.setHasFixedSize(true);
        codingRecycle.setLayoutManager(new GridLayoutManager(this,1));

        internLocations.add(new InternHelperClass(R.drawable.cc,"C Programming","sine raja", 4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.java,"Java","sine raja", 5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.python,"Python","sine raja",  4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.ruby,"Ruby","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.ccc,"C++ ","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.net,".net","sine raja",  4f,"\u20B94500"));


        InternAdapter adapter = new InternAdapter(this, internLocations);
        codingRecycle.setAdapter(adapter);


    }
}