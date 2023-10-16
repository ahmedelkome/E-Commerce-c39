package com.mis.route.e_commerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mis.route.e_commerce.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOffersViewPager()
        initCategoriesRecyclerView()
        initProductsRecyclerView()
    }

    private fun initProductsRecyclerView() {
        val productsList = getProducts()
        binding.homeAppliancesRecyclerView.adapter = ProductsRecyclerAdapter(productsList)
    }

    private fun initCategoriesRecyclerView() {
        val categoriesList = getCategories()
        binding.categoriesRecyclerView.adapter = CategoriesRecyclerAdapter(categoriesList)
    }

    private fun initOffersViewPager() {
        val offersList = getOffers()
        val adapter = OfferViewPagerAdapter(offersList)
        binding.offersViewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.offersViewPager) { tab, position ->
            //Some implementation
        }.attach()
    }

    // TODO: Sudo-function to generate offers until an endpoint is added to the API
    private fun getOffers(): List<Offer> {
        return listOf(
            Offer(1, 25, R.drawable.image_headset, "1", "For all Headphones \n& AirPods"),
            Offer(2, 30, R.drawable.image_beauty_products, "2", "For all Makeup\n& Skincare"),
            Offer(3, 20, R.drawable.image_laptop, "3", "For Laptops\n& Mobiles")
        )
    }

    // TODO: Sudo-function to generate categories until API implementation is completed
    private fun getCategories(): List<Category> {
        return listOf(
            Category(1, R.drawable.image_women_category, "Women's Fashion"),
            Category(2, R.drawable.image_men_category, "Men's Fashion"),
            Category(3, R.drawable.image_women_category, "Women's Fashion"),
            Category(4, R.drawable.image_men_category, "Men's Fashion"),
            Category(5, R.drawable.image_women_category, "Women's Fashion"),
            Category(6, R.drawable.image_men_category, "Men's Fashion"),
            Category(7, R.drawable.image_women_category, "Women's Fashion"),
            Category(8, R.drawable.image_men_category, "Men's Fashion"),
            Category(9, R.drawable.image_women_category, "Women's Fashion"),
            Category(10, R.drawable.image_men_category, "Men's Fashion"),
        )
    }

    // TODO: Sudo-function to generate products until API implementation is completed
    private fun getProducts(): List<Product> {
        return listOf(
            Product(1, R.drawable.image_headset),
            Product(2, R.drawable.image_beauty_products),
            Product(3, R.drawable.image_laptop)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}