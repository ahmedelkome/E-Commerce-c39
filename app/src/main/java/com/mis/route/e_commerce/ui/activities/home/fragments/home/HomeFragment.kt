package com.mis.route.e_commerce.ui.activities.home.fragments.home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.databinding.FragmentHomeBinding
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.CategoriesRecyclerAdapter
import com.mis.route.e_commerce.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var adapter: CategoriesRecyclerAdapter
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUI()
        initCategoryRecyclerView()
    }


    private fun renderUI() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is HomeFragmentState.CategoryLoaded -> bindCategories(it.categoryList)
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    private fun bindCategories(categoryList: List<Category?>?) {
        binding.categoriesRecyclerViewShimmer.stopShimmer()
        binding.categoriesRecyclerViewShimmer.visibility = View.INVISIBLE
        adapter.updateCategories(categoryList)
    }

    private fun initCategoryRecyclerView() {
        adapter = CategoriesRecyclerAdapter(listOf())
        binding.categoriesRecyclerView.adapter = adapter
        viewModel.invoke(HomeFragmentActions.HomeLoadedCategory)
    }


}