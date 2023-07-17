package com.elina.samplecodelabjc.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BannerHomeModel {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("shortDescription")
        @Expose
        var shortDescription: String? = null

        @SerializedName("type")
        @Expose
        var type: String? = null

        @SerializedName("websiteUrl")
        @Expose
        var websiteUrl: String? = null

        @SerializedName("linkTo")
        @Expose
        var linkTo: String? = null

        @SerializedName("linkValue")
        @Expose
        var linkValue: String? = null

        @SerializedName("keyword")
        @Expose
        var keyword: String? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        @SerializedName("appImage")
        @Expose
        var bannerImage: String? = null

        @SerializedName("position")
        @Expose
        var position: Int? = null

        @SerializedName("product")
        var product: Products? = null

        @SerializedName("category")
        var category: Categories? = null
}