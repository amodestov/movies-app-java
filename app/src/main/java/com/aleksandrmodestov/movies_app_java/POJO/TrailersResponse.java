package com.aleksandrmodestov.movies_app_java.POJO;

import com.google.gson.annotations.SerializedName;

public class TrailersResponse {

    @SerializedName("videos")
    public TrailersList trailersList;

    public TrailersResponse(TrailersList trailersList) {
        this.trailersList = trailersList;
    }

    public TrailersList getTrailersList() {
        return trailersList;
    }

    @Override
    public String toString() {
        return "TrailersResponse{" +
                "trailersList=" + trailersList +
                '}';
    }
}
