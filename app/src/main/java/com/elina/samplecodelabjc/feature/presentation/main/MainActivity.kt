package com.elina.samplecodelabjc.feature.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.elina.samplecodelabjc.feature.presentation.home.HomeFragment
import com.elina.samplecodelabjc.ui.theme.SampleCodeLabJCTheme
import dagger.hilt.android.AndroidEntryPoint
import com.elina.samplecodelabjc.R
import com.elina.samplecodelabjc.ui.ContentScreens
import com.elina.samplecodelabjc.ui.NavigationItem

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
fun KoklassAppScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
            /*  NavHost(
                  navController = navController,
                  startDestination = Route.Home.route,
              ) {
                  composable(route = Route.Home.route) {
                      HomeFragment()
                  }
              }*/
        }
    )
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
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
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
            HomeFragment()
        }
        composable(NavigationItem.Category.route) {
            ContentScreens().CategoryScreen()
        }
        composable(NavigationItem.Offer.route) {
            ContentScreens().OfferScreen()
        }
        composable(NavigationItem.More.route) {
            ContentScreens().MoreScreen()
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

