package com.elina.samplecodelabjc.ui.screen.offer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.data.network.model.BannerHomeModel
import com.elina.samplecodelabjc.data.network.model.Products
import com.elina.samplecodelabjc.ui.screen.home.HorizontalProduct

@Composable
fun OfferScreen(offerViewModel: OfferViewModel = hiltViewModel()) {
    val offerBannerAndProducts = offerViewModel.combined.collectAsState()

    val offerBanners = offerBannerAndProducts.value.offerBanners ?: emptyList()
    val offerProducts = offerBannerAndProducts.value.offerProducts ?: emptyList()
    Column(
     //   modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        if (offerBanners.isNotEmpty())
            OfferBanners(offerBanners)

        if (offerProducts.isNotEmpty()) {
            OfferProductsList(products = offerProducts)
        }
    }
}

@Composable
fun OfferProductsList(products: List<Products>) {
    Column {
        Text(
            text = "Offer Products",
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.wrapContentHeight(),
            //.heightIn(0.dp, 550.dp),
            contentPadding = PaddingValues(1.dp),
            content = {
                if (products.isNotEmpty()) {
                    items(products.size ?: 1) { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            HorizontalProduct(products[item])
                        }
                    }
                }
            })
    }
}

@Composable
fun OfferBanners(offerBanners: List<BannerHomeModel>) {
    LazyRow {
        items(items = offerBanners) { banner ->
            //    LoadImage(imageUrl = banner.bannerImage.toString())
            OfferBanner(banner.bannerImage)
        }
    }
}

@Composable
fun OfferBanner(bannerImage: String?) {
    val painter = painterResource(id = R.drawable.random_image)
    AsyncImage(
        model = bannerImage,
        contentDescription = "Banner Image",
        modifier = Modifier
            .wrapContentWidth()
            .height(200.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}