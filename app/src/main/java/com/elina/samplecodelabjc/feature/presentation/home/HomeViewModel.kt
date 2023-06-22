package com.elina.samplecodelabjc.feature.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elina.samplecodelabjc.feature.domain.model.HomeResponse
import com.elina.samplecodelabjc.feature.domain.model.LandingPageNewHome
import com.elina.samplecodelabjc.feature.shared.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Elina on 31/05/2023.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    //  val homeItemsList = MutableLiveData<List<LandingPageNewHome>?>()
    private var _homeItemsList = mutableStateOf(emptyList<LandingPageNewHome>())

    val homeItemsList: List<LandingPageNewHome>
        get() = _homeItemsList.value


    private var _isLoading = mutableStateOf(true)
    val isLoading: Boolean
        get() = _isLoading.value

    init {
        getHomeFromApi()
    }

    @SuppressLint("CheckResult")
    fun getHomeFromApi() {
        _isLoading.value = true

        val response: Observable<HomeResponse> = repository.getHomeFromApi()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("HMV", "getHomeFromApi: success")
                if (!it.data.isNullOrEmpty()) {
                    _homeItemsList.value = it.data!!
                } else {
                    _homeItemsList.value = emptyList()
                }
                _isLoading.value = false
            }, {

                Log.d("HMV", "getHomeFromApi: failure")
                _isLoading.value = false
               // _homeItemsList.value = emptyList()
            })
    }
}
