package com.mis.route.e_commerce.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.CategoryListItemBinding

class CategoriesAdapter(private val list: MutableList<String?>?) :
    Adapter<CategoriesAdapter.ViewHolder>() {

    private var selectedPosition = 0


    class ViewHolder(val viewBinding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(name: String?, isSelected: Boolean) {
            if (isSelected) {
                viewBinding.view.visibility = VISIBLE
                viewBinding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
            } else {
                viewBinding.view.visibility = View.INVISIBLE
                viewBinding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.transparent
                    )
                )
            }

            viewBinding.categoryName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            CategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = list?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list!![position], selectedPosition == position)
        onItemClickListener?.let {
            holder.viewBinding.root.setOnClickListener { i ->
                it.onClick(position, list[position]!!)
                notifyItemChanged(selectedPosition)
                selectedPosition = position
                notifyItemChanged(position)
            }
        }


    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onClick(position: Int, item: String)
    }


}