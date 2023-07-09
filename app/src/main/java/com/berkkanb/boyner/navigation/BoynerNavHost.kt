package com.berkkanb.boyner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.berkkanb.boyner.presentation.newslist.NewsListScreen
import com.berkkanb.boyner.presentation.source.SourceScreen

@Composable
fun BoynerNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BoynerNavGraph.SOURCE_GRAPH) {
        composable(BoynerNavGraph.SOURCE_GRAPH) {
            SourceScreen(navigateToNewsList = { navController.navigate("${BoynerNavGraph.NEWS_LIST_GRAPH}/$it") })
        }
        composable(
            "${BoynerNavGraph.NEWS_LIST_GRAPH}/{sourceId}",
            arguments = listOf(navArgument("sourceId") { type = NavType.StringType })
        ) {
            NewsListScreen()
        }
    }
}
