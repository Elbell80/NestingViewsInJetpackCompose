package com.elina.samplecodelabjc.domain.utils.repository

import com.elina.samplecodelabjc.data.service.RetrofitHelper
import com.elina.samplecodelabjc.data.network.model.ErrorResponse
import com.elina.samplecodelabjc.utils.constants.ErrorConstants
import com.elina.samplecodelabjc.utils.utils.GlobalUtils
import com.google.gson.Gson
import okhttp3.RequestBody
import java.io.File
import java.io.IOException
import java.net.UnknownHostException

/**
 * Created by Elina on 31/05/2023.
 */

abstract class BaseRepository {
    var apiService = RetrofitHelper.getApiService()

    fun getGlobalUtils(any: Any?): RequestBody = GlobalUtils.buildGson(any)

    fun getGlobalUtils(keyName: String?, fileName: String?, file: File?) =
        GlobalUtils.buildGson(keyName, fileName, file)

    fun getError(responseCode: Int?, error: String?): Throwable {
        return try {
            val gson = Gson()
            val root = gson.fromJson(error, ErrorResponse::class.java)
            val errorMessages = root?.errors

            if (!errorMessages.isNullOrEmpty()) {
                if (responseCode == 401) {
                    java.lang.Exception(
                        errorMessages.getOrNull(0)?.detail
                            ?: ErrorConstants.defaultMessage
                    )
                } else {
                    Throwable(errorMessages[0].detail)
                }

            } else {
                getDefaultError()
            }
        } catch (e: Exception) {
            getDefaultError()
        }
    }

    fun getError(throwable: Throwable) =
        if (throwable is UnknownHostException || throwable is IOException) {
            throwable
        } else {
            getDefaultError()
        }

    private fun getDefaultError() = Throwable(ErrorConstants.defaultMessage)
}
