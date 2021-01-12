package com.example.sha.HelperClass;

import android.widget.RatingBar;

public class LanguageHelperClass {
    int image1;
    String title1, author1, cost1;
    float ratingBar1;
    String url;

    public LanguageHelperClass(int image1, String title1, String author1, float ratingBar1, String cost1, String url) {
        this.image1 = image1;
        this.title1 = title1;
        this.author1 = author1;
        this.ratingBar1 = ratingBar1;
        this.cost1 = cost1;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getImage1() {
        return image1;
    }

    public String getTitle1() {
        return title1;
    }

    public String getAuthor1() {
        return author1;
    }

    public float getRatingBar1() {
        return ratingBar1;
    }

    public String getCost1() {
        return cost1;
    }

}
