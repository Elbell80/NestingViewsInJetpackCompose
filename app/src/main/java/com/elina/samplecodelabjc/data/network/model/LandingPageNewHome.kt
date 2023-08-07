package com.elina.samplecodelabjc.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LandingPageNewHome : Parcelable {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("status")
    var status: Boolean? = null

    @SerializedName("position")
    var position: Int? = null

    @SerializedName("appLayoutId")
    var appLayoutId: Int? = null

    @SerializedName("sectionDetails")
    var sectionDetails: LandingPageSectionDetails? = null

    @SerializedName("details")
    var details: List<LandingPageDetail>? = null

    @SerializedName("categories")
    var categories: List<Categories>? = null
}