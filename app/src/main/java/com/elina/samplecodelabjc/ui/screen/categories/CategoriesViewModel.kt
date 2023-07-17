package com.elina.samplecodelabjc.ui.screen.categories

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.data.network.model.LandingPageNewHome
import com.elina.samplecodelabjc.domain.utils.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.round

/**
 * Created by Elina on 12/07/2023.
 */

@HiltViewModel
class CategoriesViewModel @Inject constructor(var categoryRepository: CategoryRepository) :
    ViewModel() {
    private var _isLoading = mutableStateOf(true)
    val isLoading: Boolean
        get() = _isLoading.value

    private var _categoriesList = mutableStateOf(emptyList<Categories>())

    val categoriesList: List<Categories>
        get() = _categoriesList.value

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = categoryRepository.getCategories(1)
            val categoriesListFromApi = response.data?.data
            _isLoading.value = false
            if (!categoriesListFromApi.isNullOrEmpty()) {
                _categoriesList.value = categoriesListFromApi
            } else {
                _categoriesList.value = emptyList()
            }
        }
    }
}