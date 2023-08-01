package com.elina.samplecodelabjc.ui.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elina.samplecodelabjc.R

/**
 * Created by Elina on 08/06/2023.
 */

class ContentScreens {
    @Preview(showBackground = true)
    @Composable
    fun CategoryScreenPreview() {
        //CategoryScreen()
    }

    @Preview(showBackground = true)
    @Composable
    fun OfferScreenPreview() {
        // OfferScreen()
    }

    @Composable
    fun GoToOtherPage() {
        Toast.makeText(LocalContext.current, "clicked", Toast.LENGTH_SHORT).show()
    }
}


