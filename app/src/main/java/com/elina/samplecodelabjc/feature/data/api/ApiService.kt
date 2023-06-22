package com.elina.samplecodelabjc.feature.data.api

import com.elina.samplecodelabjc.feature.domain.model.HomeResponse
import com.elina.samplecodelabjc.utils.constants.ApiConstants
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by Elina on 31/05/2023.
 */

interface ApiService {
    @GET(ApiConstants.home)
    fun getHome(
        @Header(ApiConstants.apiKey) apiKey : String? = "Q7qvOMJmaaftunz5T0Tz",
        @Header(ApiConstants.warehouseIdKey) warehouseId : Int = 1
    ): Observable<HomeResponse>
}
