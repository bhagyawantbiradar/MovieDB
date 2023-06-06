package com.bhagyawant.moviedb.presentation.movie_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.databinding.ItemCastBinding
import com.bhagyawant.moviedb.domain.model.Cast

class CastAdapter(private val casts: List<Cast>) : RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemCastBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_cast, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = casts[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return casts.size
    }

    inner class ViewHolder(private val binding: ItemCastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cast: Cast) {
            binding.cast = cast
            binding.executePendingBindings()
        }
    }
}