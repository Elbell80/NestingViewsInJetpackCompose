package com.elina.samplecodelabjc.domain.repository

import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.data.network.model.CategoriesResponse
import com.elina.samplecodelabjc.data.network.model.Resource
import com.elina.samplecodelabjc.utils.constants.ErrorConstants
import com.elina.samplecodelabjc.utils.constants.StringConstants

/**
 * Created by Elina on 12/07/2023.
 */

class CategoryRepository : BaseRepository() {
    suspend fun getCategories(warehouseId: Int): Resource<CategoriesResponse> {
        val response = apiService.getCategories(warehouseId = warehouseId)
        return if (response.isSuccessful && response.body() != null) {
            if (response.body()?.data != null) {
                Resource.Success(data = response.body()!!)
            } else {
                Resource.Error(message = ErrorConstants.defaultMessage)
            }
        } else {
            Resource.Error(message = ErrorConstants.defaultMessage)
        }
    }
}
