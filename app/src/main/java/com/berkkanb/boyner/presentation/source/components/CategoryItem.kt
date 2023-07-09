package com.berkkanb.boyner.presentation.source.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val iconVector = if (isSelected) Icons.Default.Done else Icons.Default.Add
    val foregroundColor = if (isSelected) Color.White else Color.Black
    val backgroundColor = if (isSelected) Color.Black else Color.White

    Button(border = BorderStroke(1.dp, foregroundColor),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        onClick = { onClick.invoke() }) {
        Row() {
            Icon(iconVector, null, tint = foregroundColor)
            Text(text = title, color = foregroundColor)
        }
    }
}