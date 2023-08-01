package com.elina.samplecodelabjc.ui.screen.generalnotification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elina.samplecodelabjc.domain.repository.NotificationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Elina on 01/08/2023.
 */

@HiltViewModel
class GeneralNotificationViewModel @Inject constructor(private val notificationRepository: NotificationsRepository) :
    ViewModel() {

    fun getNotifications() {
        viewModelScope.launch {
            notificationRepository.getNotifications()
        }
    }
}
