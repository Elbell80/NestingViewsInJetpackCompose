package com.elina.samplecodelabjc.utils.utils

import com.elina.samplecodelabjc.utils.constants.RouteConstants.HOME_SCREEN

/**
 * Created by Elina on 01/06/2023.
 */

sealed class Route(val route: String) {
    object Home : Route(HOME_SCREEN)
}

