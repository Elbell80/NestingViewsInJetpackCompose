package com.elina.samplecodelabjc.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.elina.samplecodelabjc.ui.screen.home.HomeFragment
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme
import dagger.hilt.android.AndroidEntryPoint
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.ui.screen.ContentScreens
import com.elina.samplecodelabjc.ui.screen.CollapsingToolbarScreen
import com.elina.samplecodelabjc.ui.NavigationItem
import com.elina.samplecodelabjc.ui.screen.categories.CategoriesScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleCodeLabJCTheme {
                KoklassAppScreen()
            }
        }
    }
}

@Composable
fun ScreenWithTopAndBottomBar() {
    val navController = rememberNavController()
    val showBottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val showTopBarState = rememberSaveable { (mutableStateOf(true)) }

    /*  Box {
          NavHost(navController, startDestination = NavigationItem.Home.route) {
            *//*  composable("main_navigation") {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomNavigationBar(navController) }
                ) {  it
                    NavHost(navController, startDestination = "home") {
                        composable(NavigationItem.Home.route) { HomeFragment(navController = navController) }
                        composable(NavigationItem.Category.route) { ContentScreens().CategoryScreen() }
                        composable(NavigationItem.Offer.route) { ContentScreens().OfferScreen() }
                        composable(NavigationItem.More.route) { ContentScreens().MoreScreen() }
                    }
                }
            }*//*
            composable("details") { CollapsingToolbarScreen() }
        }
    }*/
    Scaffold(
        topBar = {
            if (showTopBarState.value)
                TopBar()
        },
        bottomBar = {
            if (showBottomBarState.value)
                BottomNavigationBar(navController = navController)
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        }
    )
}

@Composable
fun ScreenWithOutTopAndBottomBar(content: @Composable () -> Unit) {
    content()
}

@Composable
fun KoklassAppScreen() {
    ScreenWithTopAndBottomBar()
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = com.elina.samplecodelabjc.R.string.app_name),
                fontSize = 18.sp
            )
        },
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Category,
        NavigationItem.Offer,
        NavigationItem.More,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.route) {
                        Icon(
                            painter = painterResource(id = item.iconSelected),
                            contentDescription = item.title
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.iconUnselected),
                            contentDescription = item.title
                        )
                    }
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                })
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
           /* NavHost(navController = navController, startDestination = ""){
                composable("details"){
                    CollapsingToolbarScreen()
                }
            }*/
            HomeFragment(navController = navController)
        }
        composable(NavigationItem.Category.route) {
           CategoriesScreen()
        }
        composable(NavigationItem.Offer.route) {
            ContentScreens().OfferScreen()
        }
        composable(NavigationItem.More.route) {
            ContentScreens().MoreScreen()
        }
        composable("details") { it
            CollapsingToolbarScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LocalContext.current
    SampleCodeLabJCTheme {
        Greeting("Android")
    }
}

