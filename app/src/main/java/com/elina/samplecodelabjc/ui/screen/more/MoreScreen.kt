package com.elina.samplecodelabjc.ui.screen.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.ui.screen.notification.NotificationScreen
import com.elina.samplecodelabjc.utils.constants.NavigationConstants

@Composable
fun MoreScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.white))
    ) {
        MoreItems(title = "Notifications", R.drawable.ic_notifications) {
            navController.navigate(NavigationConstants.notifications)
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp)
                .height(1.dp),
            color = colorResource(id = R.color.divider_color)
        )
        MoreItems(title = "Rate Us", R.drawable.ic_notifications) {
         //    GoToOtherPage()
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp)
                .height(1.dp),
            color = colorResource(id = R.color.divider_color)
        )
        MoreItems(title = "Feedback", R.drawable.ic_notifications) {
            //   GoToOtherPage()
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp)
                .height(1.dp),
            color = colorResource(id = R.color.divider_color)
        )
        MoreItems(title = "More", R.drawable.ic_notifications) {
            //  GoToOtherPage()
        }

    }
}

@Composable
fun MoreItems(title: String, icon: Int, goToOtherPage: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable {
                goToOtherPage()
            }
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.color_text_normal),
            fontSize = 16.sp
        )
    }
}