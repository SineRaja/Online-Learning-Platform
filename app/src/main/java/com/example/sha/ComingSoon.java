package com.example.sha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class ComingSoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextView textView = findViewById(R.id.textView5);

        SharedPrefernce sharedPrefernce= new SharedPrefernce(this);
        HashMap<String, String> userDetials = sharedPrefernce.getUserDetailFromSession();

        String fullName = userDetials.get(SharedPrefernce.KEY_FULLNAME);

        textView.setText(fullName);


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
   //     new AlertDialog.Builder(this)
   //           .setTitle("Message")
   //         .setMessage("Do you want to exit app?")
   //       .setNegativeButton("NO", null)
   //      .setPositiveButton("YES", new DialogInterface.OnClickListener() {
   //        @Override
   //        public void onClick(DialogInterface dialogInterface, int i) {
   //                 HomePage.super.onBackPressed();
   //                     finish();
   //              }
   //         }).create().show();
   }

}