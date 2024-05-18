package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.EventScreens.AddScreen
import com.example.myapplication.view.EventScreens.EventScreen
import com.example.myapplication.view.NavScreens.ProfileScreen
import com.example.myapplication.view.EventScreens.StartScreen
import com.example.myapplication.view.NavScreens.MainScreen


@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route){
            StartScreen(navController)
        }
        composable(NavRoute.AddScreen.route){
            AddScreen(navController)
        }
        composable(NavRoute.EventScreen.route){
            EventScreen(navController)
        }
        composable(NavRoute.ProfileScreen.route){
            ProfileScreen(navController)
        }
        composable(NavRoute.MainScreen.route){
            MainScreen(navController)
        }
    }
}