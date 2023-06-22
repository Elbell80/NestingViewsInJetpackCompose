package com.elina.samplecodelabjc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.elina.samplecodelabjc.R

/**
 * Created by Elina on 08/06/2023.
 */

class ContentScreens {
    @Composable
    fun CategoryScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Category",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorPrimaryDark),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CategoryScreenPreview() {
        CategoryScreen()
    }

    @Composable
    fun OfferScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.purple_200))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Offer",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorPrimaryDark),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OfferScreenPreview() {
        OfferScreen()
    }

    @Composable
    fun MoreScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "More",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorPrimaryDark),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MoreScreenPreview() {
        MoreScreen()
    }
}


