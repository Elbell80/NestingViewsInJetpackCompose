package com.elina.samplecodelabjc.ui.screen.categories

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.data.network.model.LandingPageNewHome
import com.elina.samplecodelabjc.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.sample
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

    private var _categoriesList = MutableStateFlow<List<Categories>>(emptyList())

    val categoriesList: StateFlow<List<Categories>>
        get() = _categoriesList

    init {
        getCategories()
    }

    /*private fun getCategories() {
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
    }*/

    //using Flow
    private fun getCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = categoryRepository.getCategories(1)
            val categoriesListFromApi = response.data?.data
            _isLoading.value = false
            if (!categoriesListFromApi.isNullOrEmpty()) {
                _categoriesList.emit(categoriesListFromApi)
            } else {
                _categoriesList.emit(emptyList())
            }
        }
    }
}
