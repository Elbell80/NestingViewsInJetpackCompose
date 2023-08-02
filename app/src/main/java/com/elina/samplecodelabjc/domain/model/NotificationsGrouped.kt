package com.elina.samplecodelabjc.domain.model

import com.elina.samplecodelabjc.data.network.model.NotificationResponse

/**
 * Created by Elina on 02/08/2023.
 */

data class NotificationsGrouped(
    var type: String? = null,
    var date: String? = null,
    var notification: NotificationResponse? = null
)
