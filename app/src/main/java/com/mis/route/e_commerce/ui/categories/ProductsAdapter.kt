package com.mis.route.e_commerce.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mis.route.e_commerce.databinding.CatProductListItemBinding
import com.mis.route.e_commerce.ui.categories.model.category

class ProductsAdapter(var list: MutableList<category>) : Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding: CatProductListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            CatProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = list.size

    fun bindList(list: MutableList<category>) {
        var oldSize = this.list.size
        this.list = list
        notifyItemRangeChanged(0, oldSize)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.productImage.setImageResource(list[position].image)
        holder.viewBinding.productName.text = list[position].name
    }
}