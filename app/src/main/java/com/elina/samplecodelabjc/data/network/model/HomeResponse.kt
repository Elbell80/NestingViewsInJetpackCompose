package com.elina.samplecodelabjc.data.network.model

import com.google.gson.annotations.SerializedName

class HomeResponse {
    @SerializedName("data")
    var data: List<LandingPageNewHome>? = null

    @SerializedName("code")
    var code: Int? = null
}