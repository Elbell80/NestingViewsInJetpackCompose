package com.elina.samplecodelabjc.feature.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class LandingPageNewHome() :Parcelable {
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

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        status = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        position = parcel.readValue(Int::class.java.classLoader) as? Int
        appLayoutId = parcel.readValue(Int::class.java.classLoader) as? Int
        sectionDetails = parcel.readParcelable(LandingPageSectionDetails::class.java.classLoader)
        details = parcel.createTypedArrayList(LandingPageDetail)
        categories = parcel.createTypedArrayList(Categories)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeValue(status)
        parcel.writeValue(position)
        parcel.writeValue(appLayoutId)
        parcel.writeParcelable(sectionDetails, flags)
        parcel.writeTypedList(details)
        parcel.writeTypedList(categories)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LandingPageNewHome> {
        override fun createFromParcel(parcel: Parcel): LandingPageNewHome {
            return LandingPageNewHome(parcel)
        }

        override fun newArray(size: Int): Array<LandingPageNewHome?> {
            return arrayOfNulls(size)
        }
    }

}