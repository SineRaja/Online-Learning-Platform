package com.example.sha.development;

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

public class AllDevelopment extends AppCompatActivity {

    RecyclerView allDevelopmentRecycle;
    RecyclerView.Adapter adapter;
    ImageView backToHome;
    List<InternHelperClass> internLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_development);

        backToHome = findViewById(R.id.back_to_home_all);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHomeAll = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(backToHomeAll);
            }
        });

        allDevelopmentRecycle = findViewById(R.id.allDevelopment_Recycler);

        internLocations = new ArrayList<>();

        allDevelopmentRecycle.setHasFixedSize(true);
        allDevelopmentRecycle.setLayoutManager(new GridLayoutManager(this,1));

        internLocations.add(new InternHelperClass(R.drawable.angular,"Angular","sine raja", 3.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.shift,"SHIFT","sine raja", 5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.react,"REACT native","sine raja",  4.5f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.flutter,"Flutter","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.express,"Express","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.linux,"Linux","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.github,"Git","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.linuxpen,"Linux","sine raja",  4f,"\u20B94500"));
        internLocations.add(new InternHelperClass(R.drawable.ubuntu,"Ubuntu","sine raja",  4f,"\u20B94500"));


        InternAdapter adapter = new InternAdapter(this, internLocations);
        allDevelopmentRecycle.setAdapter(adapter);


    }
}