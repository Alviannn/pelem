package com.github.juviga.pelem.adapter;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.juviga.pelem.R;
import com.github.juviga.pelem.SharedData;
import com.github.juviga.pelem.models.SimpleMovie;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<SimpleMovie>movies;
    Context context;

    public DataAdapter(Context context, List<SimpleMovie>movies){
        this.movies = movies;
        Log.d("test", String.valueOf(movies.size()));
        if(this.movies.size() == 0) return;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.template_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.filmTitle.setText(movies.get(position).getTitle());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + movies.get(position).getPosterPath())
                .into(holder.filmImage);
        holder.filmDetail.setOnClickListener(toDetail->{
            //change fragment gaf
            SharedData.idMovie = movies.get(position).getId();



        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView filmTitle;
        ImageView filmImage;
        LinearLayout filmDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filmTitle = itemView.findViewById(R.id.filmTitle);
            filmImage = itemView.findViewById(R.id.filmImage);
            filmDetail = itemView.findViewById(R.id.filmDetail);
        }
    }
}
