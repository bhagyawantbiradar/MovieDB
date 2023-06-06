package com.bhagyawant.moviedb.presentation.movies_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bhagyawant.moviedb.databinding.ItemMovieBinding
import com.bhagyawant.moviedb.domain.model.Movie

class MovieAdapter(private val movies: List<Movie>, val onMovieClickListener: OnMovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.setOnClickListener {
            onMovieClickListener.onMovieClick(movie)
        }
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }
}

interface OnMovieClickListener {
    fun onMovieClick(movie: Movie)
}
