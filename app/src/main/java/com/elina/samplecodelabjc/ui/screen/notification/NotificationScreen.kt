package com.elina.samplecodelabjc.ui.screen.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.elina.samplecodelabjc.ui.screen.generalnotification.GeneralNotificationScreen
import com.elina.samplecodelabjc.ui.screen.offer.OfferScreen
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by Elina on 28/07/2023.
 */

@Composable
fun NotificationScreen() {
    var tabIndex = MutableStateFlow<Int>(0)
    //by remember { mutableStateOf(0) }

    val tabs = listOf("Home", "About", "Settings")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex.collectAsState().value) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex.value == index,
                    onClick = { tabIndex.value = index },
                    icon = {
                        when (index) {
                            0 -> Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null
                            )

                            1 -> Icon(imageVector = Icons.Default.Info, contentDescription = null)
                            //     2 -> Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        }
                    }
                )
            }
        }
        when (tabIndex.collectAsState().value) {
            0 -> GeneralNotificationScreen()
            1 -> OfferScreen()
        }
    }
}



