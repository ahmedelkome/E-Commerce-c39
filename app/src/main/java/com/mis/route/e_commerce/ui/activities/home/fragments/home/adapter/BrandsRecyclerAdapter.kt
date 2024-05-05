package com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.e_commerce.data.models.brand.Brand
import com.mis.route.e_commerce.databinding.ItemProductBinding

class BrandsRecyclerAdapter(private var brandsList: List<Brand?>?) :
    RecyclerView.Adapter<BrandsRecyclerAdapter.MyViewHolder>() {
    var diffUtilLists: DiffUtilBrands? = null


    class MyViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(brand: Brand) {
            binding.brands = brand
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = brandsList?.size ?: 0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val brand = brandsList!![position]
        holder.bind(brand!!)
    }

    fun updateBrandsList(brandsList: List<Brand?>?) {
        diffUtilLists = DiffUtilBrands(this.brandsList!!, brandsList!!)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists!!)
        this.brandsList = brandsList
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffUtilBrands(
        var oldList: List<Brand?>,
        var newList: List<Brand?>
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