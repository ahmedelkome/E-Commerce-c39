package com.mis.route.e_commerce.ui.activities.home.fragments.home

sealed class HomeFragmentActions {

    object HomeLoadedCategory : HomeFragmentActions()
    object HomeLoadedBrands : HomeFragmentActions()
}