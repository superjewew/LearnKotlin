package com.proandroiddev.normanlie.learnkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.proandroiddev.normanlie.learnkotlin.databinding.RvItemRepositoryBinding

/**
 * Created by Norman Lie on 10/18/2017.
 */
class RepositoryRecyclerViewAdapter(private var items: ArrayList<Repository>,
                                    private var listener: OnItemClickListener) :
        RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
        = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    fun replaceData(newItems: ArrayList<Repository>){ items = newItems }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding : RvItemRepositoryBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo : Repository, listener : OnItemClickListener?) {
            binding.repository = repo
            if(listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }
    }
}