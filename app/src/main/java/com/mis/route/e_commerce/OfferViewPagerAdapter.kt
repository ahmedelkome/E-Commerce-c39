package com.mis.route.e_commerce

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mis.route.e_commerce.databinding.ItemOfferViewPagerLeftBinding
import com.mis.route.e_commerce.databinding.ItemOfferViewPagerRightBinding

class OfferViewPagerAdapter(private val offersList: List<Offer>?) :
    RecyclerView.Adapter<ViewHolder>() {

    class ViewHolderLeft(val binding: ItemOfferViewPagerLeftBinding) :
        ViewHolder(binding.root)

    class ViewHolderRight(val binding: ItemOfferViewPagerRightBinding) :
        ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) ViewHolderType.LeftView.value else ViewHolderType.RightView.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == ViewHolderType.LeftView.value) {
            val binding = ItemOfferViewPagerLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderLeft(binding)
        } else {
            val binding = ItemOfferViewPagerRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderRight(binding)
        }
    }

    override fun getItemCount() = offersList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderLeft -> holder.binding.offer = offersList!![position]
            is ViewHolderRight -> holder.binding.offer = offersList!![position]
        }
    }
}