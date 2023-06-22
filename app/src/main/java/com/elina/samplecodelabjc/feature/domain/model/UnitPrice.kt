package com.elina.samplecodelabjc.feature.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UnitPrice (
    @SerializedName("id")
    var id: Int? = null ,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("sku")
    var sku: String? = null,

    @SerializedName("sellingPrice")
    var sellingPrice: Double? = null,

    @SerializedName("markedPrice")
    var markedPrice: Double? = null,

    @SerializedName("newPrice")
    var newPrice: Double? = null,

    @SerializedName("oldPrice")
    var oldPrice: Double? = null,

    @SerializedName("size")
    var size: String? = null,

    @SerializedName("barcode")
    var barcode: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("slug")
    var slug: String? = null,

    @SerializedName("hasOffer")
    var hasOffer: Boolean? = null,

    @SerializedName("taxable")
    var taxable: Boolean? = null,

    @SerializedName("status")
    var status: Boolean? = null,

    @SerializedName("visibility")
    var visibility: Boolean? = null,
    @SerializedName("alwaysAvailable")
    var alwaysAvailable: Boolean? = null,
    var stock: Double ?= 99.5,

    var isSelected: Boolean = false,
    var quantityInCart : String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Double,
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(sku)
        parcel.writeValue(sellingPrice)
        parcel.writeValue(markedPrice)
        parcel.writeValue(newPrice)
        parcel.writeValue(oldPrice)
        parcel.writeString(size)
        parcel.writeString(barcode)
        parcel.writeString(description)
        parcel.writeString(slug)
        parcel.writeValue(hasOffer)
        parcel.writeValue(taxable)
        parcel.writeValue(status)
        parcel.writeValue(visibility)
        parcel.writeValue(alwaysAvailable)
        parcel.writeValue(stock)
        parcel.writeByte(if (isSelected) 1 else 0)
        parcel.writeString(quantityInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnitPrice> {
        override fun createFromParcel(parcel: Parcel): UnitPrice {
            return UnitPrice(parcel)
        }

        override fun newArray(size: Int): Array<UnitPrice?> {
            return arrayOfNulls(size)
        }
    }
}