package com.mis.route.e_commerce

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.e_commerce.databinding.ItemCategoryBinding

class CategoriesRecyclerAdapter(private val categoriesList: List<Category>?) : RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = categoriesList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.category = categoriesList!![position]
    }
}