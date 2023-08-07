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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elina.samplecodelabjc.ui.screen.home.HomeFragment
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme
import dagger.hilt.android.AndroidEntryPoint
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.data.network.model.Products
import com.elina.samplecodelabjc.ui.screen.ContentScreens
import com.elina.samplecodelabjc.ui.screen.CollapsingToolbarScreen
import com.elina.samplecodelabjc.ui.NavigationItem
import com.elina.samplecodelabjc.ui.screen.categories.CategoriesScreen
import com.elina.samplecodelabjc.ui.screen.more.MoreScreen
import com.elina.samplecodelabjc.ui.screen.notification.NotificationScreen
import com.elina.samplecodelabjc.ui.screen.offer.OfferScreen
import com.elina.samplecodelabjc.utils.constants.NavigationConstants

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
        backgroundColor = colorResource(id = R.color.color_primary),
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
        backgroundColor = colorResource(id = R.color.color_primary),
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
                    /*  // Pop up to the start destination of the graph to
                      // avoid building up a large stack of destinations
                      // on the back stack as users select items
                      popUpTo(navController.graph.findStartDestination().id) {
                          saveState = true
                      }
                      // Avoid multiple copies of the same destination when
                      // reselecting the same item
                      launchSingleTop = true
                      // Restore state when reselecting a previously selected item
                      restoreState = true*/
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
            OfferScreen()
        }
        composable(NavigationItem.More.route) {
            MoreScreen(navController)
        }
        composable(
            "details/{product}",
            //    arguments = listOf(navArgument("product") { type = NavType.ParcelableType(Products::class.java) })
            arguments = listOf(navArgument("product") { type = NavType.StringType })
        ) { backStackEntry ->
            // val product = backStackEntry.arguments?.getParcelable<Products>("product")
            val product = backStackEntry.arguments?.getString("product")

            CollapsingToolbarScreen(product)
        }
        composable(NavigationConstants.notifications) {
            NotificationScreen()
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
    SampleCodeLabJCTheme {
        Greeting("Android")
    }
}

