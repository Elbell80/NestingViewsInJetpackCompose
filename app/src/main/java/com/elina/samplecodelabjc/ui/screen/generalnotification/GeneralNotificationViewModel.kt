package com.elina.samplecodelabjc.ui.screen.generalnotification

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.data.network.model.NotificationResponse
import com.elina.samplecodelabjc.domain.model.NotificationsGrouped
import com.elina.samplecodelabjc.domain.repository.NotificationsRepository
import com.elina.samplecodelabjc.utils.constants.StringConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Elina on 01/08/2023.
 */

@HiltViewModel
class GeneralNotificationViewModel @Inject constructor(private val notificationRepository: NotificationsRepository) :
    ViewModel() {
    private var _isLoading = mutableStateOf(true)
    val isLoading: Boolean
        get() = _isLoading.value

    private var _notificationsList = MutableStateFlow<List<NotificationsGrouped>>(emptyList())

    val notificationsList: StateFlow<List<NotificationsGrouped>>
        get() = _notificationsList

    init {
        getNotifications()
    }

    private fun getNotifications() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = notificationRepository.getNotifications()
            val notificationsListFromApi = response.data?.data
            val groupedList = groupNotifsByDate(notificationsListFromApi)
            _isLoading.value = false
            if (!notificationsListFromApi.isNullOrEmpty()) {
                _notificationsList.emit(groupedList)
            } else {
                _notificationsList.emit(emptyList())
            }
        }
    }

    private fun groupNotifsByDate(notifList: List<NotificationResponse>?): MutableList<NotificationsGrouped> {
        val newList = mutableListOf<NotificationsGrouped>()
        val notificationList = mutableListOf<NotificationResponse>()
        if (!notifList.isNullOrEmpty()) {

            for (i in notifList.indices) {
                if (i == 0) {
                    newList.add(
                        NotificationsGrouped(
                            date = notifList[0].sendTime,
                            type = StringConstants.date
                        )
                    )
                    newList.add(
                        NotificationsGrouped(
                            notification = notifList[0],
                            type = StringConstants.notifBody
                        )
                    )
                } else {
                    if (notifList[i].sendTime != notifList[i - 1].sendTime) {
                        newList.add(
                            NotificationsGrouped(
                                date = notifList[i].sendTime,
                                type = StringConstants.date
                            )
                        )
                        newList.add(
                            NotificationsGrouped(
                                notification = notifList[i],
                                type = StringConstants.notifBody
                            )
                        )
                    } else {
                        if (notifList[i].sendTime == notifList[i - 1].sendTime) {
                            newList.add(
                                NotificationsGrouped(
                                    notification = notifList[i],
                                    type = StringConstants.notifBody
                                )
                            )
                        }
                    }
                }

            }
        }
        return newList
    }
}
