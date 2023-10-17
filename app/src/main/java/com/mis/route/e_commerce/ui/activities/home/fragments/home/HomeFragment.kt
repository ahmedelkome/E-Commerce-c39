package com.mis.route.e_commerce.ui.activities.home.fragments.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.mis.route.e_commerce.ui.activities.home.fragments.home.model.HomeFragmentViewModel
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.data.DataConstants
import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.models.offer.Offer
import com.mis.route.e_commerce.databinding.FragmentHomeBinding
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.CategoriesRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.OfferViewPagerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.ProductsRecyclerAdapter
import com.mis.route.e_commerce.ui.UIConstants.whenViewIsShown

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()
    private val categoriesAdapter = CategoriesRecyclerAdapter(null)
    private val productsAdapter = ProductsRecyclerAdapter(null)
    private var isProductsAlreadyVisible = false

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
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.categoriesList.observe(viewLifecycleOwner, ::handleCategoriesLoaded)
        viewModel.productsList.observe(viewLifecycleOwner, ::handleProductsLoaded)
    }

    private fun handleProductsLoaded(productsList: List<com.mis.route.e_commerce.data.models.product.Product?>?) {
        if (!productsList.isNullOrEmpty()) {
            // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
            Handler(Looper.getMainLooper()).postDelayed({
                binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
                binding.lapsAccessoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                productsAdapter.productsList = productsList
                productsAdapter.notifyItemRangeInserted(0, productsList.size)
            }, 3000)

        }
    }

    private fun handleCategoriesLoaded(categoriesList: List<Category?>?) {
        if (!categoriesList.isNullOrEmpty()) {
            // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
            Handler(Looper.getMainLooper()).postDelayed({
                binding.categoriesRecyclerViewShimmer.stopShimmer()
                binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
                categoriesAdapter.categoriesList = categoriesList
                categoriesAdapter.notifyItemRangeInserted(0, categoriesList.size)
            }, 3000)
        }
    }

    private fun initProductsRecyclerView() {
        binding.root.whenViewIsShown(
            binding.lapsAccessoriesRecyclerViewShimmer,
            ::startLoadingProducts
        )
        binding.lapsAccessoriesRecyclerView.adapter = productsAdapter
    }

    private fun startLoadingProducts() {
        if (isProductsAlreadyVisible) return
        // TODO: load laps and accessories for now, edit later
        viewModel.getProducts(DataConstants.LAPS_ACCESSORIES_ID)
        isProductsAlreadyVisible = true
    }

    private fun initCategoriesRecyclerView() {
        viewModel.getCategories()
        binding.categoriesRecyclerView.adapter = categoriesAdapter
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

    override fun onDestroy() {
        super.onDestroy()
        binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
        binding.categoriesRecyclerViewShimmer.stopShimmer()
        _binding = null
    }
}
