package com.elina.samplecodelabjc.data.network.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.createTypedArrayList(Banner),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.createTypedArrayList(Products),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(parentId)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(productCount)
        parcel.writeString(slug)
        parcel.writeString(icon)
        parcel.writeString(backgroundImage)
        parcel.writeValue(position)
        parcel.writeValue(hasProduct)
        parcel.writeValue(avgRating)
        parcel.writeValue(ratingCount)
        parcel.writeString(userRating)
        parcel.writeTypedList(banner)
        parcel.writeString(designType)
        parcel.writeValue(hierarchyLevel)
        parcel.writeValue(isRestaurant)
        parcel.writeValue(isRestaurantOpen)
        parcel.writeTypedList(products)
        parcel.writeString(category_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Categories> {
        override fun createFromParcel(parcel: Parcel): Categories {
            return Categories(parcel)
        }

        override fun newArray(size: Int): Array<Categories?> {
            return arrayOfNulls(size)
        }
    }
}