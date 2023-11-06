package com.mis.route.e_commerce.ui.activities.home.fragments.home.contract

import androidx.lifecycle.LiveData
import com.mis.route.domain.models.category.Category
import com.mis.route.domain.models.offer.Offer
import com.mis.route.domain.models.product.Product
import com.mis.route.domain.models.subcategory.SubCategory

class HomeContract {
    interface ViewModel {
        val states: LiveData<State>
        val events: LiveData<Event>
        fun invokeAction(action: Action)
    }

    sealed class State {
        // TODO: other functionalities to be implemented later along with unit and UI tests
        class CategoriesLoading(message: String) : State()
        class CategoriesError(message: String) : State()
        class CategoriesSuccess(val categoriesList: List<Category?>?) : State()

        class SubCategoryLoading(message: String) : State()
        class SubCategoryError(message: String) : State()
        class SubCategorySuccess(val subCategory: SubCategory?) : State()

        class ProductsLoading(message: String) : State()
        class ProductsError(message: String) : State()
        class ProductsSuccess(val productsList: List<Product?>?) : State()

        class OffersLoading(message: String) : State()
        class OffersError(message: String) : State()
        class OffersSuccess(val offersList: List<Offer>?) : State()
    }

    sealed class Action {
        object GetCategories : Action()
        object GetSubCategory : Action()
        class GetProducts(val subCategoryId: String) : Action()
        object GetOffers : Action()
    }

    sealed class Event

}