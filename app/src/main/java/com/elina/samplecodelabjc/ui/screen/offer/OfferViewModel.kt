package com.elina.samplecodelabjc.ui.screen.offer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elina.samplecodelabjc.data.network.model.BannerHomeModel
import com.elina.samplecodelabjc.data.network.model.Products
import com.elina.samplecodelabjc.domain.model.OfferBannerAndProducts
import com.elina.samplecodelabjc.domain.repository.OfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Elina on 20/07/2023.
 */

@HiltViewModel
class OfferViewModel @Inject constructor(val offerRepository: OfferRepository) : ViewModel() {
    private var _combined = MutableStateFlow(OfferBannerAndProducts())
    val combined: StateFlow<OfferBannerAndProducts> get() = _combined

    init {
        performZip()
    }

    private fun performZip() {
        viewModelScope.launch {
            val banners = async { offerRepository.getOfferBanners() }
            val products = async { offerRepository.getOfferProducts() }

            val offerBanners = banners.await()
            val offerProducts = products.await()

            _combined.emit(
                OfferBannerAndProducts(
                    offerBanners = offerBanners.data?.data,
                    offerProducts = offerProducts.data?.data
                )
            )
        }
    }

    private fun getOffersBanners(): List<BannerHomeModel> {
        val bannersList = mutableListOf<BannerHomeModel>()
        viewModelScope.launch {
            val offerBanners = offerRepository.getOfferBanners().data?.data
            if (!offerBanners.isNullOrEmpty()) {
                bannersList.addAll(offerBanners)
            }
        }
        return bannersList
    }

    private fun getOfferProducts(): List<Products> {
        val offerProductsList = mutableListOf<Products>()
        viewModelScope.launch {
            val offerProducts = offerRepository.getOfferProducts().data?.data
            if (!offerProducts.isNullOrEmpty()) {
                offerProductsList.addAll(offerProducts)
            }
        }
        return offerProductsList
    }
}
