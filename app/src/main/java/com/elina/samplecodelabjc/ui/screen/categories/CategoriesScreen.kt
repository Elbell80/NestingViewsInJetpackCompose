package com.elina.samplecodelabjc.ui.screen.categories

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme
import kotlinx.coroutines.flow.observeOn

/**
 * Created by Elina on 12/07/2023.
 */

@Composable
fun CategoriesScreen(categoryViewModel: CategoriesViewModel = hiltViewModel()) {
    val isLoading = categoryViewModel.isLoading

    if (isLoading) {
        Text(text = "Loading")
    } else {
        val categories = categoryViewModel.categoriesList.collectAsState()

        CategoryScreen {
            MyCategoryScreenView(categoriesList = categories.value)
        }
    }
}

@Composable
fun CategoryScreen(content: @Composable () -> Unit) {
    SampleCodeLabJCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun MyCategoryScreenView(categoriesList: List<Categories>) {
    LazyColumn(modifier = Modifier.background(color = colorResource(id = R.color.background_color_grey))) {
        items(items = categoriesList) { item ->
            Category(item)
        }
    }
}

@Composable
fun Category(category: Categories) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = colorResource(id = R.color.purple_200))
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(140.dp)
                .height(140.dp)
                .background(color = colorResource(id = R.color.color_primary_light))
                .align(BiasAlignment(horizontalBias = 1f, verticalBias = 0f))
                .clip(RoundedCornerShape(28.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.divider_color),
                    shape = RoundedCornerShape(28.dp)
                )
        )
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .height(120.dp)
                .background(color = colorResource(id = R.color.white))
                .align(BiasAlignment(horizontalBias = -1f, verticalBias = 0f))
                .padding(end = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(BiasAlignment(verticalBias = 0f, horizontalBias = 0f))
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Text(
                    text = category.title ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    color = colorResource(id = R.color.color_dark),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = category.productCount ?: "Description not available. ",
                    modifier = Modifier
                        //.width(200.dp)
                        .wrapContentWidth()
                )
                Text(
                    text = category.description ?: "Description not available.",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .wrapContentWidth()
                        .width(200.dp)
                )
            }
        }

        AsyncImage(
            model = category.icon, contentDescription = "category Image",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .align(BiasAlignment(horizontalBias = 0.6f, verticalBias = 0f))
                .clip(RoundedCornerShape(20.dp))
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Category(
        Categories(
            title = "Dalle Momo",
            productCount = "5",
            description = "DalleDalleDalleDalleDalle"
        )
    )
}

