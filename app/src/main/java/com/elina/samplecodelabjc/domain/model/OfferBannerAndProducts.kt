package com.elina.samplecodelabjc.domain.model

import com.elina.samplecodelabjc.data.network.model.BannerHomeModel
import com.elina.samplecodelabjc.data.network.model.Products

/**
 * Created by Elina on 17/07/2023.
 */

data class OfferBannerAndProducts(
    var offerBanners: List<BannerHomeModel>? = null,
    var offerProducts: List<Products>? = null
)
