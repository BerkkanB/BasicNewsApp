package com.berkkanb.boyner.presentation.newslist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun NewsCard(
    title: String,
    imageURL: String? = null,
    isBookmarked: Boolean,
    onClickBookmark: () -> Unit
) {
    val bookmarkText = if (isBookmarked) "Remove Bookmark" else "Add Bookmark"
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeightIn(min = 400.dp)
    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = imageURL,
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Text(modifier = Modifier.padding(top = 5.dp), text = title)
            Text(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .clickable { onClickBookmark.invoke() },
                text = bookmarkText,
                color = Color.Blue
            )
        }
    }
}