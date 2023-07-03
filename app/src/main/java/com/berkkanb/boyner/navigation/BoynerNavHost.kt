package com.berkkanb.boyner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.berkkanb.boyner.presentation.source.SourceScreen

@Composable
fun BoynerNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BoynerNavGraph.SOURCE_GRAPH) {
        composable(BoynerNavGraph.SOURCE_GRAPH) {
            SourceScreen()
        }
    }
}