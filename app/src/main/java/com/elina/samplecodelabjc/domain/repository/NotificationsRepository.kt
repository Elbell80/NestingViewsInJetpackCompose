package com.elina.samplecodelabjc.domain.repository

import com.elina.samplecodelabjc.data.network.model.BaseArrayListResponse
import com.elina.samplecodelabjc.data.network.model.NotificationResponse
import com.elina.samplecodelabjc.data.network.model.Resource
import java.lang.Exception

/**
 * Created by Elina on 01/08/2023.
 */

class NotificationsRepository : BaseRepository() {
    suspend fun getNotifications(): Resource<BaseArrayListResponse<NotificationResponse>> {
        return try {
            val response = apiService.getNotifications(warehouseId = 1)
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