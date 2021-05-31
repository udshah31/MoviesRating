package com.example.moviesrating.utils

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesrating.R
import com.example.moviesrating.screen.MovieScreen
import com.example.moviesrating.screen.latestListMovie
import com.example.moviesrating.screen.popularMovieList
import com.example.moviesrating.screen.trendingMoviesList
import com.example.moviesrating.utils.Screen.*

sealed class Screen(val name: String) {

    object Movies : Screen("Movies")
    object TvSeries : Screen("TvSeries")
    object Favourite : Screen("Favourite")
    object Settings : Screen("Settings")
    object LatestListMovie : Screen("latestListMovies")
    object TrendingMoviesList : Screen("trendingListMovies")
    object PopularMovieList : Screen("popularListMovies")


}

data class BottomNavigationItem(
    val screen: Screen,
    @StringRes val resourceId: Int,
    val icon: ImageVector
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        screen = Movies,
        R.string.title_movie,
        Icons.Rounded.Home
    ),
    BottomNavigationItem(
        screen = TvSeries,
        R.string.title_tvSeries,
        Icons.Rounded.Create
    ),

    BottomNavigationItem(
        screen = Favourite,
        R.string.title_favourite,
        Icons.Rounded.Favorite
    ),

    BottomNavigationItem(
        screen = Settings,
        R.string.title_setting,
        Icons.Rounded.Settings
    ),

    )

@Composable
fun ScreenController(
    navController: NavHostController,
    topBarTitle: MutableState<String>
) {
    NavHost(
        navController = navController,
        startDestination = Movies.name,
        builder = {
            composable(Movies.name) {
                MovieScreen(navController)
                topBarTitle.value = stringResource(id = R.string.title_movie)

            }

            composable(TvSeries.name) {
                Text(text = "Tv Series")
                topBarTitle.value = stringResource(R.string.title_tvSeries)

            }

            composable(Favourite.name) {
                Text(text = "Favourite")
                topBarTitle.value = stringResource(R.string.title_favourite)
            }

            composable(Settings.name) {
                Text(text = "Setting")
                topBarTitle.value = stringResource(R.string.title_setting)
            }

            composable(LatestListMovie.name) {
                latestListMovie(navController = navController)
                topBarTitle.value = "Latest Movies"
            }

            composable(TrendingMoviesList.name) {
                trendingMoviesList(navController = navController)
                topBarTitle.value = "Trending Movies"
            }

            composable(PopularMovieList.name) {
                popularMovieList(navController = navController)
                topBarTitle.value = "Popular Movies"

            }

        })
}
