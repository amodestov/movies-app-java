package com.aleksandrmodestov.movies_app_java;

import com.aleksandrmodestov.movies_app_java.POJO.MovieResponse;
import com.aleksandrmodestov.movies_app_java.POJO.ReviewResponse;
import com.aleksandrmodestov.movies_app_java.POJO.TrailersResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?field=rating.kp&search=4-8&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{movieId}")
    Single<TrailersResponse> loadTrailers(@Path("movieId") int movieId);

    @GET("review?token=9DAT7J2-VHP4X8T-NN0FVTB-Y88R8BH&")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}
