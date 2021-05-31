package com.example.moviesrating.component.items


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.moviesrating.model.Item


@Composable
fun MovieItem(
    item: Item
) {

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(200.dp, 250.dp)
            .padding(3.dp)

    ) {
        Column(
            modifier = Modifier.apply {
                clickable(
                    onClick = { /*TODO*/ }
                )
            }
        ) {
            val image = painterResource(item.imageId)
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item.subTitle,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item.source,
                    style = MaterialTheme.typography.subtitle1
                )
            }

        }

    }

}