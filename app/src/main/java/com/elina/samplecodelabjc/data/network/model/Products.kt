package com.elina.samplecodelabjc.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Products(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var title: String,

    @SerializedName("code")
    @Expose
    var code: String,

    @SerializedName("slug")
    @Expose
    var slug: String,

    @SerializedName("status")
    @Expose
    var status: Boolean,

    @SerializedName("visibility")
    @Expose
    var visibility: Boolean,

    @SerializedName("taxable")
    @Expose
    var taxable: Boolean,

    @SerializedName("barcode")
    @Expose
    var barcode: String,

    @SerializedName("hasOffer")
    @Expose
    var hasOffer: Boolean,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("brandID")
    @Expose
    var brandID: String,

    @SerializedName("brandName")
    @Expose
    var brandName: String,

    @SerializedName("brandSlug")
    @Expose
    var brandSlug: String,

    @SerializedName("categoryID")
    @Expose
    var categoryId: Int,

    @SerializedName("categoryName")
    @Expose
    var categoryTitle: String,

    @SerializedName("categorySlug")
    @Expose
    var categorySlug: String,

    @SerializedName("moreInfo")
    @Expose
    var moreInfo: String,

    @SerializedName("taxableAmount")
    @Expose
    var taxableAmount: Double,

    @SerializedName("decimal")
    @Expose
    var decimal: Boolean,

    @SerializedName("icon")
    @Expose
    var icon: String,

    @SerializedName("variants")
    @Expose
    var unitPrice: List<UnitPrice>,

    @SerializedName("images")
    @Expose
    var images: List<Images>,


    /*  @SerializedName("brand")
      @Expose
      var brand: Brand ,*/
    var cartQuantity: String? = "",
    var isFavorite: Boolean? = false,
    var favoriteId: Int,
    var types: String,
    var toEnableBtn: Boolean? = true,
    var toEnableDeleteBtn: Boolean? = true,
    @SerializedName("link")
    @Expose
    var link: String,
    @SerializedName("restaurantId")
    @Expose
    var restaurantId: Int,

    @SerializedName("restaurantName")
    @Expose
    var restaurantName: String,

    var decimalQuantity: Boolean? = false
) : Parcelable