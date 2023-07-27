package com.elina.samplecodelabjc.domain.interactor

import com.elina.samplecodelabjc.domain.repository.OfferRepository
import javax.inject.Inject

/**
 * Created by Elina on 17/07/2023.
 */

class OfferInteractor @Inject constructor(private val offerRepository: OfferRepository) {

   /* suspend fun performMergeOperation() {

        val result1Deferred: Deferred<BaseArrayListResponse<BannerHomeModel>> =
            async { offerRepository.getOfferBanners() }
        val result2Deferred: Deferred<BaseArrayListResponse<Products>> =
            async { offerRepository.getOfferProducts() }

        Wait for all deferred results to complete
        val results = awaitAll(result1Deferred, result2Deferred)

        Process the individual results as they become available
         for (result in results) {
             reArrangeLists(result)
         }
    }*/


    suspend fun zipBannerAndProducts(){
        val bannersList = offerRepository.getOfferBanners()
        val offerProducts = offerRepository.getOfferProducts()

    }

}
