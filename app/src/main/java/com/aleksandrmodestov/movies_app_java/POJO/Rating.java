package com.aleksandrmodestov.movies_app_java.POJO;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rating implements Serializable {

    @SerializedName("kp")
    private double kinoPoiskRating;

    public Rating(double kinoPoiskRating) {
        this.kinoPoiskRating = kinoPoiskRating;
    }

    public double getKinoPoiskRating() {
        return kinoPoiskRating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp='" + kinoPoiskRating + '\'' +
                '}';
    }
}
