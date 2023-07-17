package com.elina.samplecodelabjc.data.network.model

/**
 * Created by Elina on 31/05/2023.
 */

sealed class Resource<T>(val data: T?, val message: String?) {
    class Success<T>(data: T) : Resource<T>(data, null)
    class Error<T>(message: String?) : Resource<T>(null, message)
}
