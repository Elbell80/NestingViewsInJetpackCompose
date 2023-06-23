package com.elina.samplecodelabjc.feature.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class LandingPageDetail() : Parcelable {
    @SerializedName("title")  
    var title: String? = null

    @SerializedName("webLink")
    var webLink: String? = null

    @SerializedName("linkTo")
    var linkTo: String? = null

    @SerializedName("status")  
    var status: String? = null

    @SerializedName("description")  
    var description: String? = null

    @SerializedName("category")
    var category: Categories? = null

    @SerializedName("itemId")
    var itemId: Int? = null

    @SerializedName("startDate")
    var startDate: String? = null

    @SerializedName("endDate")
    var endDate: String? = null

    @SerializedName("images")  
    var bannerImage: String? = null

    @SerializedName("id")  
    var id: Int? = null

    @SerializedName("position")  
    var position: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        webLink = parcel.readString()
        linkTo = parcel.readString()
        status = parcel.readString()
        description = parcel.readString()
        category = parcel.readParcelable(Categories::class.java.classLoader)
        itemId = parcel.readValue(Int::class.java.classLoader) as? Int
        startDate = parcel.readString()
        endDate = parcel.readString()
        bannerImage = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        position = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(webLink)
        parcel.writeString(linkTo)
        parcel.writeString(status)
        parcel.writeString(description)
        parcel.writeParcelable(category, flags)
        parcel.writeValue(itemId)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(bannerImage)
        parcel.writeValue(id)
        parcel.writeString(position)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LandingPageDetail> {
        override fun createFromParcel(parcel: Parcel): LandingPageDetail {
            return LandingPageDetail(parcel)
        }

        override fun newArray(size: Int): Array<LandingPageDetail?> {
            return arrayOfNulls(size)
        }
    }
}