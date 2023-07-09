package com.berkkanb.boyner.presentation.source.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsSourceCard(
    title:String,
    description:String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ }
    ) {
        Column() {
            Text(text = title)
            Text(text = description)
        }
    }
}