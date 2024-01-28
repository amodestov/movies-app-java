package com.aleksandrmodestov.movies_app_java;

import com.aleksandrmodestov.movies_app_java.POJO.MovieResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?field=rating.kp&search=4-8&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);
}
