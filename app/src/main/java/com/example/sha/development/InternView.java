package com.example.sha.development;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sha.R;
import com.example.sha.mainpage.HomeActivity;

public class InternView extends AppCompatActivity {
    ImageView internToHome;
    TextView internTopic;
    WebView interWebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern_view);

        internToHome = findViewById(R.id.back_to_home_HomeMain);
        internToHome.setOnClickListener(view -> {
            Intent interToHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(interToHome);
        });

        internTopic = findViewById(R.id.intern_Topic_name);
        interWebView = findViewById(R.id.intern_WebView);
        interWebView.setWebViewClient(new MyBrowser());

        Intent internIntent =getIntent();
        String internName = internIntent.getExtras().getString("internTitle");
        String url = internIntent.getExtras().getString("internUrl");
        internTopic.setText(internName);

        interWebView.getSettings().setLoadsImagesAutomatically(true);
        interWebView.getSettings().setJavaScriptEnabled(true);
        interWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        interWebView.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}