package com.example.moviesrating.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.moviesrating.component.items.MovieItem
import com.example.moviesrating.model.DemoDataProvider


@Composable
fun MovieScreen(
    navController: NavController
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)

    ) {

        val constraints = ConstraintSet {
            val latestTv = createRefFor("latestTv")
            val latestList = createRefFor("latestList")
            val trendingTv = createRefFor("trendingTv")
            val trendingList = createRefFor("trendingList")
            val popularTv = createRefFor("popularTv")
            val popularList = createRefFor("popularList")



            constrain(latestTv) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

            constrain(latestList) {
                top.linkTo(latestTv.bottom)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

            constrain(trendingTv) {
                top.linkTo(latestList.bottom)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

            constrain(trendingList) {
                top.linkTo(trendingTv.bottom)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

            constrain(popularTv) {
                top.linkTo(trendingList.bottom)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

            constrain(popularList) {
                top.linkTo(popularTv.bottom)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }


        }

        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .layoutId("latestTv"),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Latest Movies",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                )

                Text(
                    text = "More..",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    ),
                    modifier = Modifier
                        .padding(end = 10.dp, top = 10.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navController.navigate(
                                "latestListMovies"
                            )
                        }

                )

            }

            val item = DemoDataProvider.itemList

            LazyRow(modifier = Modifier.layoutId("latestList")) {
                itemsIndexed(
                    items = item
                ) { _, item ->
                    MovieItem(item = item)
                }
            }


            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .layoutId("trendingTv"),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Trending Movies",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                )

                Text(
                    text = "More..",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    ),
                    modifier = Modifier
                        .padding(end = 10.dp, top = 10.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navController.navigate("trendingListMovies")
                        }

                )

            }

            LazyRow(modifier = Modifier.layoutId("trendingList")) {
                itemsIndexed(
                    items = item
                ) { _, item ->
                    MovieItem(item = item)
                }
            }


            Row(
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .layoutId("popularTv"),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Popular Movies",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                )

                Text(
                    text = "More..",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    ),
                    modifier = Modifier
                        .padding(end = 10.dp, top = 10.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            navController.navigate("popularListMovies")
                        }

                )

            }

            LazyRow(modifier = Modifier.layoutId("popularList")) {
                itemsIndexed(
                    items = item
                ) { _, item ->
                    MovieItem(item = item)
                }
            }

        }


    }


}