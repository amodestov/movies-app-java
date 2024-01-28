package com.aleksandrmodestov.movies_app_java.POJO;

import com.google.gson.annotations.SerializedName;

public class Trailer {

    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    public Trailer(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
