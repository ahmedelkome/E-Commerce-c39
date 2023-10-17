package com.mis.route.e_commerce.di

import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.CategoriesRecyclerAdapter
import com.mis.route.e_commerce.ui.activities.home.fragments.home.adapter.ProductsRecyclerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AdaptersModule {
    @Provides
    fun provideCategoriesAdapter(): CategoriesRecyclerAdapter {
        return CategoriesRecyclerAdapter(null)
    }

    @Provides
    fun provideProductsAdapter(): ProductsRecyclerAdapter {
        return ProductsRecyclerAdapter(null)
    }
}