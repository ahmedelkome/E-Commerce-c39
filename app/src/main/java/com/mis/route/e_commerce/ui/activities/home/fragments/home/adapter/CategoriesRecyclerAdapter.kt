package com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.databinding.ItemCategoryCircularBinding

class CategoriesRecyclerAdapter(private var categoriesList: List<Category?>?) :
    RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder>() {

    private var diffUtilLists: DiffUtilLists? = null

    class ViewHolder(private val binding: ItemCategoryCircularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category?) {
            binding.title.setBackgroundColor(Color.TRANSPARENT)
            binding.image.setBackgroundColor(Color.TRANSPARENT)
            binding.category = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryCircularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = categoriesList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoriesList!![position]
        holder.bind(category)
    }

    fun updateCategories(categoriesList: List<Category?>?) {
        diffUtilLists = DiffUtilLists(this.categoriesList!!, categoriesList!!)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists!!)
        this.categoriesList = categoriesList
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffUtilLists(
        var oldList: List<Category?>,
        var newList: List<Category?>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

}