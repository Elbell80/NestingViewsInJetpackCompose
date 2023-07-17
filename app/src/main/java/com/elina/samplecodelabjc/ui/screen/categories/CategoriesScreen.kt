package com.elina.samplecodelabjc.ui.screen.categories

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.data.network.model.Categories
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme

/**
 * Created by Elina on 12/07/2023.
 */

@Composable
fun CategoriesScreen(categoryViewModel: CategoriesViewModel = hiltViewModel()) {
    val isLoading = categoryViewModel.isLoading

    val categoriesList = categoryViewModel.categoriesList

    CategoryScreen {
        MyCategoryScreenView(categoriesList = categoriesList)
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
    LazyColumn {
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
            .height(200.dp)
    ) {
        val painter = rememberAsyncImagePainter(category.backgroundImage)
        Image(
            painter = painterResource(id = R.drawable.category_bg),
            contentDescription = "Category Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(align = Alignment.Center)
        ) {
            Text(
                text = category.title ?: "",
                modifier = Modifier
                    .width(200.dp)
                    .wrapContentHeight(),
                color = colorResource(id = R.color.color_dark),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = category.productCount ?: "",
                modifier = Modifier.width(200.dp)
            )
            Text(
                text = category.description ?: "",
                modifier = Modifier.width(200.dp)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    /*Category(
        Categories(
            title = "Dalle Momo",
            productCount = "5",
            description = "Dalle MomoDalle MomoDalle MomoDalle MomoDalle MomoDalle MomoDalle Momo"
        )
    )*/
}

