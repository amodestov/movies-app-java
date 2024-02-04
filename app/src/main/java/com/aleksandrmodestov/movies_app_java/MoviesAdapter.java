package com.aleksandrmodestov.movies_app_java;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.aleksandrmodestov.movies_app_java.POJO.Movie;
import com.aleksandrmodestov.movies_app_java.POJO.MovieResponse;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies = new ArrayList<>();
    private OnReachEndListener onReachEndListener;
    private OnClickMovieListener onClickMovieListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setOnClickMovieListener(OnClickMovieListener onClickMovieListener) {
        this.onClickMovieListener = onClickMovieListener;
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(holder.itemView)
                .load(movie.getPoster().getUrl())
                .into(holder.imageViewPoster);
        double rating = movie.getRating().getKinoPoiskRating();
        int background;
        if (rating >= 7.0) {
            background = R.drawable.circle_green;
        } else if (rating >= 5.0) {
            background = R.drawable.circle_yellow;
        } else {
            background = R.drawable.circle_red;
        }
        Drawable backgroundDrawable = ContextCompat.getDrawable(
                holder.itemView.getContext(),
                background);
        holder.textViewRating.setBackground(backgroundDrawable);
        holder.textViewRating.setText(String.format(
                Locale.getDefault(),
                "%.1f",
                movie.getRating().getKinoPoiskRating())
        );

        if (position == movies.size() - 10 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickMovieListener != null) {
                    onClickMovieListener.onClickMovie(movie);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    interface OnReachEndListener {
        void onReachEnd();
    }

    interface OnClickMovieListener {
        void onClickMovie(Movie movie);
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewPoster;
        private final TextView textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
