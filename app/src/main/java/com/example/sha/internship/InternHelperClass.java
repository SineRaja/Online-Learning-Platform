package com.example.sha.internship;

public class InternHelperClass {
    int internOfImage;
    String internOfTitle, internOfAuthor, internOfCost;
    float internRating;

    public InternHelperClass(int internOfImage, String internOfTitle, String internOfAuthor, float internRating, String internOfCost) {
        this.internOfImage = internOfImage;
        this.internOfTitle = internOfTitle;
        this.internOfAuthor = internOfAuthor;
        this.internRating = internRating;
        this.internOfCost = internOfCost;

    }

    public int getInternOfImage() {
        return internOfImage;
    }

    public String getInternOfTitle() {
        return internOfTitle;
    }

    public String getInternOfAuthor() {
        return internOfAuthor;
    }

    public String getInternOfCost() {
        return internOfCost;
    }

    public float getInternRating() {
        return internRating;
    }
}
