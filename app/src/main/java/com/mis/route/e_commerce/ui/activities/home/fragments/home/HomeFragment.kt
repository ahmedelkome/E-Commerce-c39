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
import com.mis.route.data.DataConstants
import com.mis.route.e_commerce.databinding.FragmentHomeBinding
import com.mis.route.e_commerce.ui.UIConstants.whenViewIsShown
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.CategoriesRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.OfferViewPagerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.ProductsRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.contract.HomeContract
import com.mis.route.e_commerce.ui.activities.home.fragments.home.model.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // automatically injected
    private val viewModel: HomeFragmentViewModel by viewModels()

    // stop injection for now
    private var categoriesAdapter = CategoriesRecyclerAdapter(null)
    private var productsAdapter = ProductsRecyclerAdapter(null)
    private var isProductsAlreadyVisible = false
    private var offersAdapter = OfferViewPagerAdapter(null)

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
        viewModel.states.observe(viewLifecycleOwner, ::renderViews)
        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    private fun handleEvents(event: HomeContract.Event) {
        TODO("Not yet implemented")
    }

    private fun renderViews(state: HomeContract.State) {
        when (state) {
            is HomeContract.State.CategoriesSuccess -> bindCategories(state)
            is HomeContract.State.CategoriesError -> TODO()
            is HomeContract.State.CategoriesLoading -> TODO()

            is HomeContract.State.ProductsError -> TODO()
            is HomeContract.State.ProductsLoading -> TODO()
            is HomeContract.State.ProductsSuccess -> bindProducts(state)

            is HomeContract.State.SubCategoryError -> TODO()
            is HomeContract.State.SubCategoryLoading -> TODO()
            is HomeContract.State.SubCategorySuccess -> TODO()

            is HomeContract.State.OffersError -> TODO()
            is HomeContract.State.OffersLoading -> TODO()
            is HomeContract.State.OffersSuccess -> bindOffers(state)
        }
    }

    private fun bindOffers(state: HomeContract.State.OffersSuccess) {
        if (state.offersList.isNullOrEmpty()) return
        offersAdapter.offersList = state.offersList
        offersAdapter.notifyItemRangeInserted(0, state.offersList.size)
    }

    private fun bindCategories(state: HomeContract.State.CategoriesSuccess) {
        if (state.categoriesList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoriesRecyclerViewShimmer.stopShimmer()
            binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
            categoriesAdapter.categoriesList = state.categoriesList
            categoriesAdapter.notifyItemRangeInserted(0, state.categoriesList.size)
        }, 1000)
    }

    private fun bindProducts(state: HomeContract.State.ProductsSuccess) {
        if (state.productsList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
            binding.lapsAccessoriesRecyclerViewShimmer.visibility = View.INVISIBLE
            productsAdapter.productsList = state.productsList
            productsAdapter.notifyItemRangeInserted(0, state.productsList.size)
        }, 1000)
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
        // TODO: load "laps and accessories" for now, edit later
        viewModel.invokeAction(HomeContract.Action.GetProducts(DataConstants.LAPS_ACCESSORIES_ID))
        isProductsAlreadyVisible = true
    }

    private fun initCategoriesRecyclerView() {
        viewModel.invokeAction(HomeContract.Action.GetCategories)
        binding.categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun initOffersViewPager() {
        viewModel.invokeAction(HomeContract.Action.GetOffers)
        binding.offersViewPager.adapter = offersAdapter
        TabLayoutMediator(binding.tabLayout, binding.offersViewPager) { tab, position ->
            //Some implementation
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.lapsAccessoriesRecyclerViewShimmer.stopShimmer()
        binding.categoriesRecyclerViewShimmer.stopShimmer()
        _binding = null
    }
}
