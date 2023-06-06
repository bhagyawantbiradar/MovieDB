package com.bhagyawant.moviedb.presentation.movie_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.databinding.ItemGenreBinding

class GenreAdapter(private val items: List<String>) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemGenreBinding = DataBindingUtil.inflate(inflater, R.layout.item_genre, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}
