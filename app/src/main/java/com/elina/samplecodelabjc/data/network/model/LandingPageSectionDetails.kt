package com.elina.samplecodelabjc.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class LandingPageSectionDetails : Parcelable {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("designType")
    var designType: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("autoScroll")
    var autoScroll: String? = null

    var showMore: Boolean? = null

    @SerializedName("collectionType")
    var collectionType: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("start_date")
    var startDate: String? = null

    @SerializedName("end_date")
    var endDate: String? = null

    @SerializedName("products")
    var products: List<Products>? = null


    @SerializedName("categories")
    var categories: List<Categories>? = null
}