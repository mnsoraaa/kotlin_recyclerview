package com.example.kotlin_recyclerview.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.data.interfaces.RecyclerClickListener
import com.example.kotlin_recyclerview.data.models.Movie
import com.example.kotlin_recyclerview.databinding.RecyclerviewMovieBinding

class MovieAdapter(
    private val movies : List<Movie>,
    private val listener : RecyclerClickListener
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(
        val recyclerViewMovieBinding : RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerViewMovieBinding.root)

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerViewMovieBinding.movie = movies[position]

        holder.recyclerViewMovieBinding.buttonBook.setOnClickListener{
            listener.onRecyclerViewClickListener(
                holder.recyclerViewMovieBinding.buttonBook, movies[position]
            )
        }

        holder.recyclerViewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewClickListener(
                holder.recyclerViewMovieBinding.layoutLike, movies[position]
            )
        }
    }
}