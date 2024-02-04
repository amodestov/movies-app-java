package com.aleksandrmodestov.movies_app_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.aleksandrmodestov.movies_app_java.POJO.Movie;

import java.util.List;

public class FavouriteMoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFavouriteMovies;
    private MoviesAdapter moviesAdapter;
    private FavouriteMoviesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movies);
        initViews();
        moviesAdapter = new MoviesAdapter();
        recyclerViewFavouriteMovies.setAdapter(moviesAdapter);
        recyclerViewFavouriteMovies.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel = new ViewModelProvider(this).get(FavouriteMoviesViewModel.class);
        viewModel.getAllFavouriteMovies().observe(
                this,
                new Observer<List<Movie>>() {
                    @Override
                    public void onChanged(List<Movie> favouriteMovies) {
                        moviesAdapter.setMovies(favouriteMovies);
                    }
                }
        );
        moviesAdapter.setOnClickMovieListener(new MoviesAdapter.OnClickMovieListener() {
            @Override
            public void onClickMovie(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteMoviesActivity.this,
                        movie);
                startActivity(intent);
            };
        });
    }

    private void initViews() {
        recyclerViewFavouriteMovies = findViewById(R.id.recyclerViewFavouriteMovies);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteMoviesActivity.class);
    }
}
