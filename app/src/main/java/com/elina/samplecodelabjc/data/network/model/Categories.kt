package com.elina.samplecodelabjc.data.network.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("parentId")
    var parentId: String? = null,

    @SerializedName("name")
    var title: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("productCount")
    var productCount: String? = null,

    @SerializedName("slug")
    var slug: String? = null,

    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("backgroundImage")
    var backgroundImage: String? = null,

    @SerializedName("position")
    var position: Int? = null,

    @SerializedName("hasProduct")
    var hasProduct: Boolean? = null,

    @SerializedName("avgRating")
    var avgRating: Double? = null,

    @SerializedName("ratingCount")
    var ratingCount: Int? = null,

    @SerializedName("yourRating")
    var userRating: String? = null,

    @SerializedName("banner")
    var banner: MutableList<Banner>? = null,

    var designType: String? = null,

    @SerializedName("level")
    var hierarchyLevel: Int? = null,
    @SerializedName("isRestaurant")
    var isRestaurant: Boolean? = null,
    @SerializedName("restaurantOpen")
    var isRestaurantOpen: Boolean? = null,

    @SerializedName("items")
    var products: List<Products>? = null,

    @SerializedName("category_id")
    var category_id: String? = null // for rating post success
) : Parcelable
