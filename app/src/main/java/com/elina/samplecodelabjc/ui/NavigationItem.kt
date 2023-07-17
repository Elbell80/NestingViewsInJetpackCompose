package com.elina.samplecodelabjc.ui

import com.elina.samplecodelabjc.R

/**
 * Created by Elina on 08/06/2023.
 */

sealed class NavigationItem(var route: String, var iconUnselected: Int,var iconSelected: Int,  var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, R.drawable.ic_home_selected,"Home")
    object Category : NavigationItem("categories", R.drawable.ic_category, R.drawable.ic_home_selected,"Category")
    object Offer : NavigationItem("offer", R.drawable.ic_offer, R.drawable.ic_home_selected,"Offer")
    object More : NavigationItem("more", R.drawable.ic_more, R.drawable.ic_home_selected,"More")
}
