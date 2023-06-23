package com.elina.samplecodelabjc.feature.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.elina.samplecodelabjc.feature.domain.model.*
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme
import com.elina.samplecodelabjc.utils.constants.StringConstants
import com.elina.samplecodelabjc.R

/**
 * Created by Elina on 01/06/2023.
 */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeItemList: List<LandingPageNewHome>
) {
    MYyHomeScreen {
        MyHomeItemsView(homeItemList = homeItemList)
    }
}

@Composable
fun MYyHomeScreen(content: @Composable () -> Unit) {
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
fun MyHomeItemsView(homeItemList: List<LandingPageNewHome>) {
    LazyColumn {
        items(items = homeItemList) { item ->
            when (item.title) {
                StringConstants.banner -> {
                    val bannersList = item.details
                    if (bannersList != null) {
                        HorizontalView(bannersList = bannersList)
                    }
                }
                StringConstants.productsCollection -> {
                    ProductCollection(item.sectionDetails)
                }
                StringConstants.category -> {
                    CategoriesList(landingPageNewHome = item)
                }
                StringConstants.brandTags -> {}
                else -> {}
            }
        }
    }
}

@Composable
fun HorizontalView(bannersList: List<LandingPageDetail>) {
    LazyRow {
        items(items = bannersList) { banner ->
            Banner(bannerImage = banner.bannerImage ?: "")
        }
    }
}

@Composable
fun HorizontalProduct(product: Products?) {
    Box(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(220.dp)
                .background(Color.White)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                val painter = rememberAsyncImagePainter(product?.images?.get(0)?.imageName)
                LoadImage(imageUrl = product?.images?.get(0)?.imageName ?: "")

                Text(
                    text = product?.title.toString(),
                    modifier = Modifier
                        //.padding(top = 16.dp),
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 2
                )
                Text(
                    text = product?.description ?: "N/A",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp),
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun ProductCollection(sectionDetails: LandingPageSectionDetails?) {
    val products = sectionDetails?.products
    val manrope = FontFamily(Font(R.font.manrope_bold))
    Text(
        text = sectionDetails?.title.toString(),
        style = TextStyle(
            fontFamily = manrope,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        color = colorResource(id = R.color.color_dark),
        modifier = Modifier.padding(start = 16.dp)
    )
    when (sectionDetails?.designType) {
        StringConstants.horizontalType -> {
            LazyRow {
                items(items = products!!) { product ->
                    HorizontalProduct(product)
                }
            }
        }
        StringConstants.gridType -> {
            GridProduct(sectionDetails)
        }
        StringConstants.verticalType -> {
            LazyColumn(modifier = Modifier.heightIn(200.dp, 700.dp)) {
                itemsIndexed(products!!) { index, item ->
                    val bottomPadding = if (index == products.size.minus(1)) {
                        16.dp
                    } else {
                        0.dp
                    }

                    VerticalProduct(item, bottomPadding)
                }
            }
        }
    }
}

@Composable
fun Banner(bannerImage: String) {
    val painter = rememberAsyncImagePainter(bannerImage)
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
    //   LoadImage(imageUrl = bannerImage)
    Image(
        painter = painterResource(id = R.drawable.random_image),
        //painter = painter,
        contentDescription = "Banner Image",
        modifier = Modifier
            .padding(8.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .clip(RoundedCornerShape(8.dp))
        //    contentScale = ContentScale.FillWidth
    )
    //}
}

@Composable
fun CategoryDesign(category: Categories) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            //.height(150.dp)
            //  .width(100.dp)
            .padding(8.dp)
    ) {
        Column {
            val painter: Painter = rememberAsyncImagePainter(category.icon)
            Image(
                painter = painter,
                contentDescription = "Category Image",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = category.title ?: "",
                modifier = Modifier
                    .wrapContentHeight()
                    .width(100.dp),
                //.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CategoriesList(landingPageNewHome: LandingPageNewHome) {
    val manrope = FontFamily(Font(R.font.manrope_bold))
    Text(
        text = landingPageNewHome.sectionDetails?.title.toString(),
        style = TextStyle(
            fontFamily = manrope,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        color = colorResource(id = R.color.color_dark),
        modifier = Modifier.padding(start = 16.dp)
    )
    LazyRow {
        items(items = landingPageNewHome.categories!!) { category ->
            CategoryDesign(category)
        }
    }
}

@Composable
fun GridProduct(sectionDetails: LandingPageSectionDetails?) {
    val products = sectionDetails?.products
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.heightIn(0.dp, 550.dp),
        contentPadding = PaddingValues(1.dp),
        content = {
            if (!products.isNullOrEmpty()) {
                items(products.size ?: 1) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        HorizontalProduct(products[item])
                    }
                }
            }
        }
    )
}

@Composable
fun VerticalProduct(product: Products?, bottomPadding: Dp) {
    Box(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = bottomPadding)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = 5.dp,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row {
                val painter = rememberAsyncImagePainter(product?.images?.get(0)?.imageName)
                Image(
                    painter = painter,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    Text(
                        text = product?.title.toString(),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        color = colorResource(id = R.color.black),
                    )

                    Text(
                        text = stringResource(
                            id = R.string.new_price,
                            getPrice(product).toString()
                        ),
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(8.dp),
                        color = colorResource(id = R.color.colorPrimary),
                    )
                }
            }
        }
    }
}

@Composable
fun LoadImage(imageUrl: String) {
    val painter =
        rememberAsyncImagePainter(model = imageUrl)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
    )
}

fun getPrice(product: Products?): Double {
    return if (product?.unitPrice?.get(0)?.hasOffer == true) {
        product.unitPrice?.get(0)?.newPrice ?: 0.0
    } else {
        product?.unitPrice?.get(0)?.sellingPrice ?: 0.0
    }
}

@Preview
@Composable
fun HorizontalPrev() {
    HorizontalProduct(product = Products())
}


