package com.elina.samplecodelabjc.feature.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elina.samplecodelabjc.ui.screen.home.HomeViewModel
import com.elina.samplecodelabjc.domain.repository.HomeRepository

/**
 * Created by Elina on 31/05/2023.
 */

class HomeViewModelFactory constructor(private val repository: HomeRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
