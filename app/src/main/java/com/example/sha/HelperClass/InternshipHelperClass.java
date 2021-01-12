package com.example.sha.HelperClass;

public class InternshipHelperClass {

    int image;
    String title, cost, authorIntern, url;
    float ratingBarIntern;

    public InternshipHelperClass(int image, String title, String cost, String authorIntern, String url, float ratingBarIntern) {
        this.image = image;
        this.title = title;
        this.cost = cost;
        this.authorIntern = authorIntern;
        this.url = url;
        this.ratingBarIntern = ratingBarIntern;
    }

    public String getAuthorIntern() {
        return authorIntern;
    }

    public float getRatingBarIntern() {
        return ratingBarIntern;
    }

    public String getUrl() {
        return url;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }
}
