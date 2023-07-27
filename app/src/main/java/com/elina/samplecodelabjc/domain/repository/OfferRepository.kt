package com.elina.samplecodelabjc.domain.repository

import com.elina.samplecodelabjc.data.network.model.BannerHomeModel
import com.elina.samplecodelabjc.data.network.model.BaseArrayListResponse
import com.elina.samplecodelabjc.data.network.model.Products
import com.elina.samplecodelabjc.data.network.model.Resource
import java.lang.Exception

/**
 * Created by Elina on 17/07/2023.
 */

class OfferRepository : BaseRepository() {
    suspend fun getOfferBanners(): Resource<BaseArrayListResponse<BannerHomeModel>> {
        return try {
            val response = apiService.getOfferBanner()
            if (response.body() != null && response.body()?.data != null) {
                Resource.Success(data = response.body()!!)
            } else {
                Resource.Error(message = response.errorBody()?.string().toString())
            }
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage)
        }
    }

    suspend fun getOfferProducts(): Resource<BaseArrayListResponse<Products>> {
        return try {
            val response = apiService.getAllProducts(warehouseId = 1)
            if (response.body() != null && response.body()?.data != null) {
                Resource.Success(data = response.body()!!)
            } else {
                Resource.Error(message = response.errorBody()?.string().toString())
            }
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage)
        }
    }
}
