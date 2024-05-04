package com.mis.route.e_commerce.ui.activities.home.fragments.home

import com.mis.route.e_commerce.data.models.category.Category

sealed class HomeFragmentState {
    class CategoryLoaded(val categoryList: List<Category?>?) : HomeFragmentState()
}
