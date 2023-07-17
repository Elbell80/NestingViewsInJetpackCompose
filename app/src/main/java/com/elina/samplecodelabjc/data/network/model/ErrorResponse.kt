package com.elina.samplecodelabjc.data.network.model

/**
 * Created by Elina on 24/05/2023.
 */

data class ErrorResponse(
    val errors: List<Error>? = null,
)

data class Error(
    var title: String? = null,
    var detail: String? = null,
    var source: ArrayList<String>? = null,
)