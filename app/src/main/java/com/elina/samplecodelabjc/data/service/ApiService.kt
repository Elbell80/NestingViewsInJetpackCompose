package com.elina.samplecodelabjc.data.service

import com.elina.samplecodelabjc.data.network.model.BannerHomeModel
import com.elina.samplecodelabjc.data.network.model.BaseArrayListResponse
import com.elina.samplecodelabjc.data.network.model.CategoriesResponse
import com.elina.samplecodelabjc.data.network.model.HomeResponse
import com.elina.samplecodelabjc.data.network.model.Products
import com.elina.samplecodelabjc.utils.constants.ApiConstants
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by Elina on 31/05/2023.
 */

interface ApiService {
    @GET(ApiConstants.home)
    fun getHome(
        @Header(ApiConstants.apiKey) apiKey: String? = "Q7qvOMJmaaftunz5T0Tz",
        @Header(ApiConstants.warehouseIdKey) warehouseId: Int = 1
    ): Observable<HomeResponse>

    @GET(ApiConstants.categories)
    suspend fun getCategories(
        @Header(ApiConstants.apiKey) apiKey: String? = "Q7qvOMJmaaftunz5T0Tz",
        @Header(ApiConstants.warehouseIdKey) warehouseId: Int = 1
    ): Response<CategoriesResponse>

    @GET(ApiConstants.banner)
    suspend fun getOfferBanner(
        @Header(ApiConstants.apiKey) apiKey: String? = "Q7qvOMJmaaftunz5T0Tz",
        @Header(ApiConstants.warehouseIdKey) warehouseId: Int = 1,
        @Query(ApiConstants.type) type: String
    ): Response<BaseArrayListResponse<BannerHomeModel>>

    @GET(ApiConstants.product)
    fun getAllProducts(
        @Header(ApiConstants.apiKey) apiKey: String = "Q7qvOMJmaaftunz5T0Tz",
        @Header(ApiConstants.warehouseIdKey) warehouseId: Int,
    ): Single<Response<BaseArrayListResponse<Products>>>
}
