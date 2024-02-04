package com.aleksandrmodestov.movies_app_java;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.aleksandrmodestov.movies_app_java.POJO.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    public static final String TYPE_POSITIVE = "Позитивный";
    public static final String TYPE_NEGATIVE = "Негативный";
    private List<Review> reviewList = new ArrayList<>();

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {
        Review review = reviewList.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getReview());
        int background = android.R.color.darker_gray;
        if (review.getType() != null) {
            switch (review.getType()) {
                case TYPE_POSITIVE:
                    background = android.R.color.holo_green_light;
                    break;
                case TYPE_NEGATIVE:
                    background = android.R.color.holo_red_light;
                    break;
            }
        }
        Drawable color = ContextCompat.getDrawable(holder.itemView.getContext(), background);
        holder.linearLayoutContainer.setBackground(color);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout linearLayoutContainer;
        private final TextView textViewAuthor;
        private final TextView textViewReview;

        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
        }
    }
}
