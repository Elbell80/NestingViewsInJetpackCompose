package com.elina.samplecodelabjc.ui

import com.elina.samplecodelabjc.R

/**
 * Created by Elina on 08/06/2023.
 */

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Category : NavigationItem("categories", R.drawable.ic_category, "Category")
    object Offer : NavigationItem("offer", R.drawable.ic_offer, "Offer")
    object More : NavigationItem("more", R.drawable.ic_more, "More")
}
