package com.elina.samplecodelabjc.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NotificationResponse(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("sendTime")
    @Expose
    var sendTime: String? = null,

    @SerializedName("typeId")
    @Expose
    var typeId: String? = null,

    var image: String? = null
)