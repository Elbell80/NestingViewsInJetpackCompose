package com.elina.samplecodelabjc.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Banner (
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Banner> {
        override fun createFromParcel(parcel: Parcel): Banner {
            return Banner(parcel)
        }

        override fun newArray(size: Int): Array<Banner?> {
            return arrayOfNulls(size)
        }
    }
}

