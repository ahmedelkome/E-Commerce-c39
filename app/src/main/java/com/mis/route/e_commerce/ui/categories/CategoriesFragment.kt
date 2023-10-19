package com.mis.route.e_commerce.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentCategoriesBinding
import com.mis.route.e_commerce.ui.categories.model.category

class CategoriesFragment : Fragment() {
    lateinit var viewBinding: FragmentCategoriesBinding
    val list = mutableListOf<String?>(
        "Mens", "Women", "Children", "old"
    )
    val categoriesMan = mutableListOf(
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
        category("Men fashion", R.drawable.mens),
    )
    val categoriesWoman = mutableListOf(
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),
        category("Women fashion", R.drawable.ic1),

        )
    val adapter = CategoriesAdapter(list)
    val pro_adapter = ProductsAdapter(categoriesMan)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCategoriesBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.rec.adapter = adapter
        viewBinding.productRec.adapter = pro_adapter
        adapter.onItemClickListener = CategoriesAdapter.OnItemClickListener { position, item ->
            when (item) {
                "Mens" -> {
                    pro_adapter.bindList(categoriesMan)
                    viewBinding.img.setImageResource(R.drawable.ic2)
                    viewBinding.catTv.text = "Men Fashion"
                    viewBinding.onImageTv.text = "Men Fashion"
                }

                "Women" -> {
                    pro_adapter.bindList(categoriesWoman)
                    viewBinding.img.setImageResource(R.drawable.ic3)
                    viewBinding.catTv.text = "Women Fashion"
                    viewBinding.onImageTv.text = "Women Fashion"
                }
            }
        }
    }


}