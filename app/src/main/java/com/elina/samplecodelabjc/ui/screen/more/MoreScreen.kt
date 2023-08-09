package com.elina.samplecodelabjc.ui.screen.more

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.ui.screen.NotificationActivity
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            val manrope = FontFamily(Font(R.font.manrope_bold))
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(start = 16.dp, top = 28.dp),
                contentDescription = "THis is logo"
            )
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login_title),
                    color = colorResource(id = R.color.color_dark),
                    fontFamily = manrope,
                    fontSize = 20.sp
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(id = R.string.login_desc),
                    color = colorResource(id = R.color.color_text_normal),
                    fontFamily = manrope,
                    fontSize = 14.sp
                )
                Button(
                    onClick = {
                        //showLoginBottomSheet()
                    },
                    modifier = Modifier
                        .wrapContentWidth()
                        .background(color = colorResource(id = R.color.color_primary)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        color = colorResource(id = R.color.white),
                        fontFamily = manrope,
                        fontSize = 14.sp
                    )
                }
            }
        }
        MoreItems(title = "Notifications", R.drawable.ic_notifications) {
            navController.navigate(NavigationConstants.notifications)
            //  goToNotif()
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

@Composable
fun showLoginBottomSheet() {
/*    ModalBottomSheetLayout(sheetContent = ) {
        
    }*/
}