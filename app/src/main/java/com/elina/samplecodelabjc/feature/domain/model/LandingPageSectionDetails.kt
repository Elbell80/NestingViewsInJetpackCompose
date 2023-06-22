package com.elina.samplecodelabjc.feature.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class LandingPageSectionDetails() : Parcelable {
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

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        designType = parcel.readString()
        type = parcel.readString()
        autoScroll = parcel.readString()
        showMore = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        collectionType = parcel.readString()
        description = parcel.readString()
        startDate = parcel.readString()
        endDate = parcel.readString()
        products = parcel.createTypedArrayList(Products)
        categories = parcel.createTypedArrayList(Categories)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(designType)
        parcel.writeString(type)
        parcel.writeString(autoScroll)
        parcel.writeValue(showMore)
        parcel.writeString(collectionType)
        parcel.writeString(description)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeTypedList(products)
        parcel.writeTypedList(categories)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LandingPageSectionDetails> {
        override fun createFromParcel(parcel: Parcel): LandingPageSectionDetails {
            return LandingPageSectionDetails(parcel)
        }

        override fun newArray(size: Int): Array<LandingPageSectionDetails?> {
            return arrayOfNulls(size)
        }
    }

}