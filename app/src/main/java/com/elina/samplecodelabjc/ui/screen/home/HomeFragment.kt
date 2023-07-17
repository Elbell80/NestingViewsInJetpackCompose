package com.elina.samplecodelabjc.ui.screen.home

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.elina.samplecodelabjc.data.network.model.LandingPageNewHome
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Elina on 31/05/2023.
 */

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val isLoading = homeViewModel.isLoading

    if (isLoading) {
        Text(text = "Loading hoyela")
    } else {
        val homesItemsListFromVM = homeViewModel.homeItemsList
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                homeItemList = homesItemsListFromVM,
                navController = navController
            )
        }
    }
}
