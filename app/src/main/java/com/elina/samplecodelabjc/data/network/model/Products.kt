package com.elina.samplecodelabjc.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var title: String? = null,

    @SerializedName("code")
    @Expose
    var code: String? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("visibility")
    @Expose
    var visibility: Boolean? = null,

    @SerializedName("taxable")
    @Expose
    var taxable: Boolean? = null,

    @SerializedName("barcode")
    @Expose
    var barcode: String? = null,

    @SerializedName("hasOffer")
    @Expose
    var hasOffer: Boolean? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("brandID")
    @Expose
    var brandID: String? = null,

    @SerializedName("brandName")
    @Expose
    var brandName: String? = null,

    @SerializedName("brandSlug")
    @Expose
    var brandSlug: String? = null,

    @SerializedName("categoryID")
    @Expose
    var categoryId: Int? = null,

    @SerializedName("categoryName")
    @Expose
    var categoryTitle: String? = null,

    @SerializedName("categorySlug")
    @Expose
    var categorySlug: String? = null,

    @SerializedName("moreInfo")
    @Expose
    var moreInfo: String? = null,

    @SerializedName("taxableAmount")
    @Expose
    var taxableAmount: Double? = null,

    @SerializedName("decimal")
    @Expose
    var decimal: Boolean? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null,

    @SerializedName("variants")
    @Expose
    var unitPrice: List<UnitPrice>? = null,

    @SerializedName("images")
    @Expose
    var images: List<Images>? = null,


    /*  @SerializedName("brand")
      @Expose
      var brand: Brand? = null,*/
    var cartQuantity: String? = "",
    var isFavorite: Boolean? = false,
    var favoriteId: Int? = null,
    var types: String? = null,
    var toEnableBtn: Boolean? = true,
    var toEnableDeleteBtn: Boolean? = true,
    @SerializedName("link")
    @Expose
    var link: String? = null,
    @SerializedName("restaurantId")
    @Expose
    var restaurantId: Int? = null,

    @SerializedName("restaurantName")
    @Expose
    var restaurantName: String? = null,

    var decimalQuantity: Boolean? = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.createTypedArrayList(UnitPrice),
        parcel.createTypedArrayList(Images),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(code)
        parcel.writeString(slug)
        parcel.writeValue(status)
        parcel.writeValue(visibility)
        parcel.writeValue(taxable)
        parcel.writeString(barcode)
        parcel.writeValue(hasOffer)
        parcel.writeString(description)
        parcel.writeString(brandID)
        parcel.writeString(brandName)
        parcel.writeString(brandSlug)
        parcel.writeValue(categoryId)
        parcel.writeString(categoryTitle)
        parcel.writeString(categorySlug)
        parcel.writeString(moreInfo)
        parcel.writeValue(taxableAmount)
        parcel.writeValue(decimal)
        parcel.writeString(icon)
        parcel.writeTypedList(unitPrice)
        parcel.writeTypedList(images)
        parcel.writeString(cartQuantity)
        parcel.writeValue(isFavorite)
        parcel.writeValue(favoriteId)
        parcel.writeString(types)
        parcel.writeValue(toEnableBtn)
        parcel.writeValue(toEnableDeleteBtn)
        parcel.writeString(link)
        parcel.writeValue(restaurantId)
        parcel.writeString(restaurantName)
        parcel.writeValue(decimalQuantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Products> {
        override fun createFromParcel(parcel: Parcel): Products {
            return Products(parcel)
        }

        override fun newArray(size: Int): Array<Products?> {
            return arrayOfNulls(size)
        }
    }
}