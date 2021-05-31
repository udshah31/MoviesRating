package com.example.moviesrating.component.naviagtion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.moviesrating.utils.Screen
import com.example.moviesrating.utils.ScreenController
import com.example.moviesrating.utils.bottomNavigationItems


@Composable
fun BottomNav() {

    val navController = rememberNavController()
    val title = remember { mutableStateOf("") }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title.value,
                        style = TextStyle(
                            fontSize = 25.sp,
                        )
                    )
                }
            )
        },


        bottomBar = {

            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

            if (canShowBottomBar(navBackStackEntry)) {

                BottomNavigation {

                    bottomNavigationItems.forEach {
                        BottomNavigationItem(
                            unselectedContentColor = Color.Black,
                            selectedContentColor = Color.White,
                            icon = { Icon(imageVector = it.icon, contentDescription = "") },
                            label = {
                                Text(
                                    text = stringResource(id = it.resourceId)
                                )
                            },
                            alwaysShowLabel = false,
                            selected = currentRoute == it.screen.name,
                            onClick = {
                                navController.popBackStack(
                                    navController.graph.startDestination,
                                    false
                                )
                                if (currentRoute != it.screen.name) {
                                    navController.navigate(it.screen.name)
                                }
                            }

                        )
                    }
                }
            }
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            ScreenController(navController, title)
        }
    }

}


private fun canShowBottomBar(navBackStackEntry: NavBackStackEntry?): Boolean {
    val keyRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    if (keyRoute != null) {
        return keyRoute.contains(Screen.Movies.name) ||
                keyRoute.contains(Screen.TvSeries.name) ||
                keyRoute.contains(Screen.Favourite.name) ||
                keyRoute.contains(Screen.Settings.name)
    }
    return false
}



