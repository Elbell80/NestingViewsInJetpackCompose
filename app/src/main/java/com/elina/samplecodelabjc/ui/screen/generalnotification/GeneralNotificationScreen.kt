package com.elina.samplecodelabjc.ui.screen.generalnotification

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.data.network.model.NotificationResponse
import com.elina.samplecodelabjc.utils.constants.StringConstants

@Composable
fun GeneralNotificationScreen(notificationsViewModel: GeneralNotificationViewModel = hiltViewModel()) {
    val notifications = notificationsViewModel.notificationsList.collectAsState()
    val isLoading = notificationsViewModel.isLoading

    if (isLoading)
        Text(text = "Notifications Loading")

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(notifications.value) { notif ->
            when (notif.type) {
                StringConstants.date -> {
                    NotificationDate(notif.date)
                }

                StringConstants.notifBody -> {
                    NotificationBody(notif.notification)
                }
            }
        }
    }
}

@Composable
fun NotificationDate(date: String?) {
    //""2023 May 24"
    val day = date?.substringAfterLast(" ")
    val year = date?.substringBefore(" ")
    val month = date?.substringAfter(" ")?.substringBeforeLast(" ")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = colorResource(id = R.color.divider_color))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = day.toString(),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                color = Color.Black,
                fontSize = 18.sp,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = month.toString(),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = year.toString(),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }
        }

    }
}

@Composable
fun NotificationBody(notification: NotificationResponse?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .wrapContentHeight()
    ) {
        Text(
            text = notification?.title.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .wrapContentHeight(),
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
        Text(
            text = notification?.title.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            color = Color.DarkGray
        )
        Divider(
            modifier = Modifier.height(8.dp),
            color = colorResource(id = R.color.divider_color)
        )
    }
}

@Composable
@Preview
fun ShowPreview() {
    NotificationDate(date = "2034 May 14")
    /* NotificationBody(
         notification = NotificationResponse(
             title = "test test",
             message = "tet test test test"
         )
     )*/
}