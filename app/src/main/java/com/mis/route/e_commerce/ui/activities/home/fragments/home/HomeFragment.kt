package com.mis.route.e_commerce.ui.activities.home.fragments.home


import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentHomeBinding
import com.mis.route.e_commerce.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

}