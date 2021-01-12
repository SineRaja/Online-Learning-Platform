package com.example.sha.coding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sha.R;
import com.example.sha.mainpage.HomeActivity;

public class CodingView extends AppCompatActivity {
    ImageView backToHome, TopicImage;
    TextView codingTopic, TopicAuthor;
    RatingBar TopicRating;
    WebView codingWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding_view);

        backToHome = findViewById(R.id.back_to_home_codingMain);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(backToHome);
            }
        });

        codingTopic = findViewById(R.id.coding_Topic_name);
        TopicImage = findViewById(R.id.codingImageView);
        TopicAuthor = findViewById(R.id.codingViewAuthor);
        TopicRating = findViewById(R.id.codingViewRating);
        codingWebView = findViewById(R.id.coding_webView);
        codingWebView.setWebViewClient(new MyBrowser());

        Intent codingClassIntent = getIntent();
        String codingName = codingClassIntent.getExtras().getString("CodingTitle");
        String url = codingClassIntent.getExtras().getString("codingLink");
        String codingAuthor = codingClassIntent.getExtras().getString("codingAuthor");
        int codingImage = codingClassIntent.getExtras().getInt("codingImage");
        float codingRating = codingClassIntent.getExtras().getFloat("codingRating");
        codingTopic.setText(codingName);
        TopicAuthor.setText(codingAuthor);
        TopicImage.setImageResource(codingImage);
        TopicRating.setRating(codingRating);

        codingWebView.getSettings().setLoadsImagesAutomatically(true);
        codingWebView.getSettings().setJavaScriptEnabled(true);
        codingWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        codingWebView.loadUrl(url);


    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}